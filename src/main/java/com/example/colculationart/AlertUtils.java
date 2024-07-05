package com.example.colculationart;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Утилитный класс для отображения ошибок в виде всплывающих окон в JavaFX.
 */
public class AlertUtils {

    /**
     * Отображает окно ошибки с указанным заголовком и сообщением.
     *
     * <p>Этот метод должен вызываться из любого потока. Внутри метода используется
     * {@link Platform#runLater(Runnable)}, чтобы убедиться, что обновление пользовательского интерфейса
     * происходит на главном потоке JavaFX.</p>
     *
     * @param title   заголовок окна ошибки
     * @param message сообщение ошибки, которое будет отображаться в окне
     */
    public static void showError(String title, String message) {
        if (Platform.isFxApplicationThread()) {
            // Если уже находимся в FX Application Thread, просто показываем диалог
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.show();
        } else {
            // Иначе используем Platform.runLater
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.show();
            });
        }
    }
}
