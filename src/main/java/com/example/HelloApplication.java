package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ggrafikrechner.fxml")));
        primaryStage.setTitle("FXML Application");
        primaryStage.setScene(new Scene(root, 700, 420));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}