package com.example.colculationart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Главный класс JavaFX приложения.
 */
public class HelloApplication extends Application {
    private static final Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    /**
     * Запускает JavaFX приложение.
     *
     * <p>Метод выполняет следующие шаги:
     * <ul>
     *     <li>Устанавливает соединение с базой данных.</li>
     *     <li>Проверяет наличие записей в таблице 'heroes'.</li>
     *     <li>Загружает соответствующий FXML файл в зависимости от наличия записей в таблице.</li>
     *     <li>Создает и отображает основное окно приложения.</li>
     * </ul>
     *
     * @param stage основной контейнер для всех элементов JavaFX.
     */
    @Override
    public void start(Stage stage) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection == null) {
                return;
            }

            boolean hasRecords = hasRecordsInHeroesTable(connection);

            FXMLLoader characterLoader = new FXMLLoader(HelloApplication.class.getResource(hasRecords ? "insertArt-view.fxml" : "load-view.fxml"));
            Parent root = characterLoader.load();
            Scene characterScene = new Scene(root);

            stage.setTitle("Calculation Art");
            stage.setMinWidth(750); // Устанавливаем минимальную ширину
            stage.setMinHeight(730); // Устанавливаем минимальную высоту
            stage.setScene(characterScene);

            // Устанавливаем размер окна по содержимому
            stage.sizeToScene();
            stage.show();
        } catch (IOException e) {
            logger.error("Произошла ошибка при запуске приложения", e);
            AlertUtils.showError("Ошибка запуска", "Произошла ошибка при запуске приложения: " + e.getMessage());
        } catch (SQLException e) {
            logger.error("Не удалось закрыть соединение с базой данных", e);
            AlertUtils.showError("Ошибка базы данных", "Не удалось закрыть соединение с базой данных: " + e.getMessage());
        }
    }

    /**
     * Проверяет наличие записей в таблице 'heroes'.
     *
     * @param connection объект {@link Connection}, представляющий соединение с базой данных.
     * @return {@code true}, если в таблице 'heroes' есть записи, иначе {@code false}.
     */
    private boolean hasRecordsInHeroesTable(Connection connection) {
        String query = "SELECT COUNT(*) FROM heroes";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            if (tableDoesNotExist(e)) {
                logger.info("Таблица 'heroes' не существует");
            } else {
                logger.error("Ошибка при проверке записей в таблице 'heroes'", e);
                AlertUtils.showError("Ошибка базы данных", "Ошибка при проверке записей в таблице 'heroes': " + e.getMessage());
            }
        }

        return false;
    }

    /**
     * Проверяет, существует ли таблица 'heroes' в базе данных.
     *
     * @param e исключение {@link SQLException}, выброшенное при попытке доступа к таблице.
     * @return {@code true}, если таблица 'heroes' не существует, иначе {@code false}.
     */
    private boolean tableDoesNotExist(SQLException e) {
        return e.getMessage().toLowerCase().contains("table 'heroes' doesn't exist");
    }

    /**
     * Главный метод, запускающий JavaFX приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        launch();
    }
}
