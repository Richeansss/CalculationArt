package com.example.colculationart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {

        if(hasRecordsInHeroesTable(DataBaseHandler.getConnection())) {
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
        }else {
            FXMLLoader CharacterLoader = new FXMLLoader(HelloApplication.class.getResource("load-view.fxml"));

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
    }


    private boolean hasRecordsInHeroesTable(Connection connection) {
        // Ваш SQL-запрос для проверки наличия записей в таблице "heroes"
        String query = "SELECT COUNT(*) FROM heroes";

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                // Если есть хотя бы одна запись, вернуть true
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            // Возможная ошибка при выполнении запроса
            if (e.getMessage().toLowerCase().contains("table 'heroes' doesn't exist")) {
                // Если таблицы не существует, вывести сообщение, но продолжить выполнение кода
                System.out.println("Таблица 'heroes' не существует");
            } else {
                // Если возникла другая ошибка, вывести сообщение и перебросить ее
                e.printStackTrace();
            }
        }

        // Если нет записей (и не было ошибок), вернуть false
        return false;
    }

    public static void main(String[] args) {
        launch();
    }
}