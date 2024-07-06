package com.example.colculationart;

import com.example.colculationart.utils.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Управление созданием и удалением таблиц в базе данных.
 */
public class Tables {

    private static final Logger logger = LoggerFactory.getLogger(Tables.class);

    /**
     * Устанавливает соединение с базой данных, удаляет существующую таблицу Heroes и создает новую таблицу Heroes.
     */
    public static void getConnectionResetAndCreate() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                try (conn) {
                    logger.info("Connection to database established successfully.");

                    dropHeroesTable(conn);
                    // Дополнительные методы для удаления других таблиц
                    // dropCompatibilityTable(conn);
                    // dropPerfectArtTable(conn);
                    // dropSoSoTable(conn);
                    // dropBadTable(conn);

                    logger.info("Existing table 'Heroes' dropped.");

                    createHeroesTable(conn);
                }
                // Всегда закрываем соединение в блоке finally
            } else {
                logger.error("Failed to establish database connection.");
            }
        } catch (Exception ex) {
            logger.error("Failed to establish database connection or execute SQL statements.", ex);
        }
    }

    /**
     * Создает таблицу Heroes в базе данных.
     *
     * @param connection соединение с базой данных
     * @throws SQLException если происходит ошибка при выполнении SQL-запроса
     */
    private static void createHeroesTable(Connection connection) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Heroes ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "Name VARCHAR(255),"
                + "SetName VARCHAR(255),"
                + "BestWeapon VARCHAR(255),"
                + "ReplacementWeapons VARCHAR(255),"
                + "BestArtifacts VARCHAR(255),"
                + "Sands VARCHAR(255),"
                + "Goblet VARCHAR(255),"
                + "Circlet VARCHAR(255),"
                + "Substats VARCHAR(255)"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
        }
    }

    /**
     * Удаляет таблицу Heroes из базы данных, если она существует.
     *
     * @param connection соединение с базой данных
     * @throws SQLException если происходит ошибка при выполнении SQL-запроса
     */
    public static void dropHeroesTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Heroes";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    // Добавление методов для удаления других таблиц (dropPerfectArtTable, dropSoSoTable, dropBadTable, dropCompatibilityTable)

    /**
     * Удаляет таблицу PerfectArt из базы данных, если она существует.
     *
     * @param connection соединение с базой данных
     * @throws SQLException если происходит ошибка при выполнении SQL-запроса
     */
    public static void dropPerfectArtTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS PerfectArt";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    /**
     * Удаляет таблицу SoSo из базы данных, если она существует.
     *
     * @param connection соединение с базой данных
     * @throws SQLException если происходит ошибка при выполнении SQL-запроса
     */
    public static void dropSoSoTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS SoSo";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    /**
     * Удаляет таблицу Bad из базы данных, если она существует.
     *
     * @param connection соединение с базой данных
     * @throws SQLException если происходит ошибка при выполнении SQL-запроса
     */
    public static void dropBadTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Bad";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    /**
     * Удаляет таблицу Compatibility из базы данных, если она существует.
     *
     * @param connection соединение с базой данных
     * @throws SQLException если происходит ошибка при выполнении SQL-запроса
     */
    public static void dropCompatibilityTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Compatibility";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }
}
