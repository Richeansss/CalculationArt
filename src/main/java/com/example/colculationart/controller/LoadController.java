package com.example.colculationart.controller;

import com.example.colculationart.utils.DatabaseConnection;
import com.example.colculationart.parser.ParserHtml;
import com.example.colculationart.utils.ProgressBarUpdater;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Контроллер для загрузочного экрана.
 */
public class LoadController implements ProgressBarUpdater {

    private static final Logger logger = LoggerFactory.getLogger(LoadController.class);

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label characterLabel;

    /**
     * Инициализация контроллера.
     * Запускает процесс загрузки данных и отображения прогресса.
     */
    public void initialize() {
        try {
            DatabaseConnection.getConnection(); // Подключение к базе данных

            Task<Void> task = new Task<>() {
                @Override
                protected Void call() {
                    ParserHtml parserHtml = new ParserHtml();
                    parserHtml.setProgressBarUpdater(LoadController.this);

                    // Запуск парсинга с передачей экземпляра контроллера
                    ParserHtml.PerCharacter(parserHtml);

                    return null;
                }
            };

            // Запуск задачи в отдельном потоке
            Thread thread = new Thread(task);
            thread.start();

            // Обработка завершения задачи
            task.setOnSucceeded(e -> {
                // Выполнение действий при успешном завершении задачи (например, открытие новой страницы)
                openNewPage();
            });
        } catch (IOException e) {
            logger.error("Ошибка при инициализации загрузочного контроллера", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод обновления прогресса загрузки данных.
     *
     * @param progress      текущий прогресс (от 0 до 1)
     * @param characterName имя обрабатываемого персонажа
     */
    @Override
    public void updateProgressBar(double progress, String characterName) {
        // Обновление прогресс-бара в потоке JavaFX
        Platform.runLater(() -> {
            characterLabel.setText(characterName);
            progressBar.setProgress(progress);
        });
    }

    /**
     * Открытие новой страницы после завершения загрузки данных.
     */
    private void openNewPage() {
        try {
            // Загрузка FXML-файла новой страницы
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/colculationart/insertArt-view.fxml"));
            Parent root = loader.load();

            // Создание новой сцены
            Scene scene = new Scene(root);

            // Получение текущего Stage
            Stage currentStage = (Stage) progressBar.getScene().getWindow();

            // Замена текущей сцены на новую
            currentStage.setScene(scene);

            // Показ новой сцены
            currentStage.show();
        } catch (IOException ex) {
            logger.error("Ошибка при открытии новой страницы", ex);
        }
    }
}
