package com.example.colculationart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader CharacterLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene CharacterScene = new Scene(CharacterLoader.load(), 854 , 480);
        stage.setTitle("Calculation Art");
        stage.setMinWidth(300);
        stage.setMinHeight(300);
        stage.setScene(CharacterScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}