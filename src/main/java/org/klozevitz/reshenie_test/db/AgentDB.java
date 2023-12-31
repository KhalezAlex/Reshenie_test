package org.klozevitz.reshenie_test.db;

import org.klozevitz.reshenie_test.entity.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.sql.*;

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

    public LinkedList<Patient> getPersonsByString(String query) {
        LinkedList<Patient> patients = new LinkedList<>();
        String baseQuery = "SELECT * FROM java_tasks_patient WHERE";
        String queryToExecute = queryToExecute(baseQuery, "fio", query.split(" "));
        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(queryToExecute);
            while (result.next()) {
                patients.add(getFromResult(result));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    private Patient getFromResult(ResultSet result) throws SQLException {
        return new Patient(
                Integer.parseInt(result.getString("id")),
                result.getString("fio"),
                getDate(result.getString("birth_date")),
                Integer.parseInt(result.getString("sex")),
                Integer.parseInt(result.getString("num")),
                result.getString("smo"),
                result.getString("snils"),
                result.getString("policy"),
                Integer.parseInt(result.getString("fin_source")
        ));
    }

    private LocalDate getDate(String date) {
        String[] birthDate = date.split("-");
        return LocalDate.of(Integer.parseInt(birthDate[0]),
                Integer.parseInt(birthDate[1]), Integer.parseInt(birthDate[2]));
    }

    private String queryToExecute(String query, String field, String[] args) {
        StringBuilder sb = new StringBuilder(query);
        for (String arg : args) {
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