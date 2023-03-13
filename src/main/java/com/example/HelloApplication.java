package com.example;

import com.example.grafikrechner.Polynom;
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
        // launch(args);
        Polynom myPolnomial = new Polynom(new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0});
        System.out.println(myPolnomial.getAxisSymmetry());
    }
}