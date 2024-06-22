package com.example.colculationart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables {

    public static void getConnectionResetAndCreate() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DatabaseConnection.getConnection()){
                System.out.println("Connection to Store DB succesfull!");

                dropHeroesTable(conn);
                //dropCompatibilityTable(conn);
                //dropPerfectArtTable(conn);
                //dropSoSoTable(conn);
                //dropBadTable(conn);

                System.out.println("Table erase");

                createHeroesTable(conn);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

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

    public static void dropHeroesTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Heroes";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    public static void dropPerfectArtTable(Connection connection)throws SQLException{
        String dropTableQuery = "DROP TABLE IF EXISTS PerfectArt";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }
    public static void dropSoSoTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS SoSo";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    public static void dropBadTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Bad";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }

    public static void dropCompatibilityTable(Connection connection) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Compatibility";

        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableQuery);
        }
    }
}