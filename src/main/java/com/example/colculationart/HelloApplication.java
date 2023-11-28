package com.example.colculationart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader CharacterLoader = new FXMLLoader(HelloApplication.class.getResource("insertArt-view.fxml"));

        Parent root = CharacterLoader.load();
        Scene characterScene = new Scene(root);
        Stage stage1 = new Stage();

        stage1.setTitle("Calculation Art");
        stage1.setMinWidth(750); // Устанавливаем минимальную ширину
        stage1.setMinHeight(730); // Устанавливаем минимальную высоту
        stage1.setScene(characterScene);

// Устанавливаем размер окна по содержимому
        stage1.sizeToScene();

        stage1.show();
    }

    public static void main(String[] args) {
        launch();
    }
}