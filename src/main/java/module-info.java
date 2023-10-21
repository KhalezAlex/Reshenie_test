module org.klozevitz.reshenie_test {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.postgresql.jdbc;

    opens org.klozevitz.reshenie_test to javafx.fxml;
    exports org.klozevitz.reshenie_test;
}