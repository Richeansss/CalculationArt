package com.example.colculationart;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoadController implements ProgressBarUpdater {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label characterLabel;


    public void initialize() {
        // Создаем и запускаем задачу
        try {
            DataBaseHandler.getConnection();
            Task<Void> task = new Task<>() {
                @Override
                protected Void call() {
                    ParserHtml parserHtml = new ParserHtml();
                    parserHtml.setProgressBarUpdater(LoadController.this);

                    // Запуск функции с передачей экземпляра контроллера
                    ParserHtml.PerCharacter(parserHtml);

                    return null;
                }
            };

            // Запускаем задачу в отдельном потоке
            Thread thread = new Thread(task);
            thread.start();

            task.setOnSucceeded(e -> {
                // Выполните ваш код для открытия новой страницы здесь
                openNewPage();
            });
        } catch (SQLException e) {
            progressBar.setVisible(false);
            characterLabel.setText("Нет подключения к базе данных");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateProgressBar(double progress, String characterName) {
        // Обновление прогресс-бара в потоке JavaFX
        Platform.runLater(() -> {
            characterLabel.setText(characterName);
            progressBar.setProgress(progress);
        });
    }

    private void openNewPage() {
        try {
            // Загружаем FXML-файл
            FXMLLoader loader = new FXMLLoader(getClass().getResource("insertArt-view.fxml"));
            Parent root = loader.load();

            // Создаем новую сцену
            Scene scene = new Scene(root);

            // Получаем текущий Stage
            Stage currentStage = (Stage) progressBar.getScene().getWindow();

            // Заменяем сцену на новую
            currentStage.setScene(scene);

            // Показываем новую сцену
            currentStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            // Обработка ошибок при загрузке FXML
        }
    }
}