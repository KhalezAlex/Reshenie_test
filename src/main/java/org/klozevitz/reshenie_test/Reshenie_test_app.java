package org.klozevitz.reshenie_test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.klozevitz.reshenie_test.db.AgentDB;

import java.io.IOException;
import java.net.DatagramSocket;
import java.sql.SQLException;

public class Reshenie_test_app extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Reshenie_test_app.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Test_app");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        AgentDB agent = new AgentDB();
        System.out.println(agent.getPersonsByString("Рома нна"));
    }

    public static void main(String[] args) {
        launch();
    }
}