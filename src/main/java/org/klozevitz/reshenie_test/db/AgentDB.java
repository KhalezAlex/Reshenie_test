import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AgentDB {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/etalon";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "ItsMyLife0203";
    private Connection connection;

    public AgentDB() {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AgentDB(String url, String name, String password) {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<String> getPersonsByString(String query) {
        LinkedList<String> persons = new LinkedList<>();
        String baseQuery = "SELECT fio FROM java_tasks_patient WHERE";
        String queryToExecute = queryToExecute(baseQuery, "fio", query.split(" "));
        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(queryToExecute);
            while (result.next()) {
                persons.add(result.getString("fio"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    private String queryToExecute(String query, String field,  String[] args) {
        StringBuilder sb = new StringBuilder(query);
        for (String arg: args) {
            sb.append(" OR ")
                    .append(field)
                    .append(" LIKE '%")
                    .append(arg)
                    .append("%'");
        }
        sb.delete(sb.indexOf("OR"), sb.indexOf("OR") + 2);
        return sb.toString();
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}