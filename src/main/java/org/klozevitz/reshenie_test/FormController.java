package org.klozevitz.reshenie_test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FormController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}