module org.klozevitz.reshenie_test {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens org.klozevitz.reshenie_test to javafx.fxml;
    exports org.klozevitz.reshenie_test;
}