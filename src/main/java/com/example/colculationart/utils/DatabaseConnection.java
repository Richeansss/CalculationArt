package com.example.colculationart.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Утилитный класс для установления соединения с базой данных.
 */
public class DatabaseConnection {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);

    /**
     * Устанавливает соединение с базой данных, используя свойства, определенные в конфигурационном файле.
     *
     * <p>Конфигурационный файл должен находиться по пути "database.properties.txt" и содержать
     * следующие свойства:
     * <ul>
     *     <li>url - URL базы данных</li>
     *     <li>username - имя пользователя базы данных</li>
     *     <li>password - пароль базы данных</li>
     * </ul>
     *
     * @return объект {@link Connection} в случае успешного подключения, или {@code null}, если подключение не удалось.
     * @throws IOException если возникает ошибка при чтении конфигурационного файла.
     */
    public static Connection getConnection() throws IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties.txt"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.error("Не удалось подключиться к базе данных: {}", e.getMessage(), e);
            AlertUtils.showError("Ошибка подключения", "Не удалось подключиться к базе данных: " + e.getMessage());
            return null;
        }
    }
}
