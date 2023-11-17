package com.example.colculationart;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DataBaseHandler {
    public static void InsertToDB(String characterName) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()){

                System.out.println("Connection to Store DB succesfull!");

                String filePath = "SoureceDataBase/" + characterName + ".txt";
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                ArrayList<String> Hero = new ArrayList<>();


                while ((line = reader.readLine()) != null) {
                    // Здесь вы можете выполнить необходимую обработку данных перед записью в базу данных
                    // Например, разделить строку на поля и подготовить их для вставки

                    // Пример: разбиение строки по табуляции
                    String[] data = line.split("\t");

                    for(int i = 0; i < data.length; i++){
                        //System.out.println(data[i]);
                        if(i==1){
                            Hero.add(data[1]);
                        }
                        else
                        {
                            Hero.add(data[i]);
                        }
                    }
                    //System.out.println("\n");


                }

                //for(int i = 0; i < Hero.size(); i++){
                //    System.out.println(Hero.get(i));
                //}

                System.out.println(Hero.size());

                    if(Hero.size()>14 && Hero.size()<30) {
                        Hero.remove(0);
                        Hero.remove(1);
                        Hero.remove(2);
                        Hero.remove(3);
                        Hero.remove(6);
                        Hero.remove(9);
                        Hero.remove(10);
                        Hero.remove(11);
                        Hero.remove(12);
                        Hero.remove(15);
                        String insertQuery = "INSERT INTO Heroes (Name, SetName, BestWeapon , ReplacementWeapons, BestArtifacts, Sands, Goblet, Circlet, Substats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(7));
                        preparedStatement.setString(3, Hero.get(0)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(1)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(2));
                        preparedStatement.setString(6, Hero.get(3));
                        preparedStatement.setString(7, Hero.get(4));
                        preparedStatement.setString(8, Hero.get(5));
                        preparedStatement.setString(9, Hero.get(6));
                        preparedStatement.executeUpdate();
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(16));
                        preparedStatement.setString(3, Hero.get(9)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(10)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(11));
                        preparedStatement.setString(6, Hero.get(12));
                        preparedStatement.setString(7, Hero.get(13));
                        preparedStatement.setString(8, Hero.get(14));
                        preparedStatement.setString(9, Hero.get(15));
                        preparedStatement.executeUpdate();

                    }
                    else if (Hero.size()>31 && Hero.size()<40) {
                        Hero.remove(0);
                        Hero.remove(1);
                        Hero.remove(2);
                        Hero.remove(3);
                        Hero.remove(6);
                        Hero.remove(8);
                        Hero.remove(7);

                        Hero.remove(9);
                        Hero.remove(10);
                        Hero.remove(11);
                        Hero.remove(12);
                        Hero.remove(15);
                        Hero.remove(16);
                        Hero.remove(16);

                        String insertQuery = "INSERT INTO Heroes (Name, SetName, BestWeapon , ReplacementWeapons, BestArtifacts, Sands, Goblet, Circlet, Substats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(7));
                        preparedStatement.setString(3, Hero.get(0)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(1)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(2));
                        preparedStatement.setString(6, Hero.get(3));
                        preparedStatement.setString(7, Hero.get(4));
                        preparedStatement.setString(8, Hero.get(5));
                        preparedStatement.setString(9, Hero.get(6));
                        preparedStatement.executeUpdate();
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(16));
                        preparedStatement.setString(3, Hero.get(9)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(10)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(11));
                        preparedStatement.setString(6, Hero.get(12));
                        preparedStatement.setString(7, Hero.get(13));
                        preparedStatement.setString(8, Hero.get(14));
                        preparedStatement.setString(9, Hero.get(15));
                        preparedStatement.executeUpdate();
                    }
                    else if (Hero.size()>41 &&  Hero.size()<63) {
                        if(Objects.equals(characterName, "Kirara") |  Objects.equals(characterName, "Layla") | Objects.equals(characterName, "Kaveh")| Objects.equals(characterName, "Yaoyao")| Objects.equals(characterName, "Faruzan")) {
                            Hero.remove(0);
                            Hero.remove(1);
                            Hero.remove(2);
                            Hero.remove(3);
                            Hero.remove(6);
                            Hero.remove(7);
                            Hero.remove(7);
                            Hero.remove(9);
                            Hero.remove(10);
                            Hero.remove(11);
                            Hero.remove(12);
                            Hero.remove(15);
                            Hero.remove(16);
                            Hero.remove(16);
                            Hero.remove(18);
                            Hero.remove(19);
                            Hero.remove(20);
                            Hero.remove(21);
                            Hero.remove(24);
                            Hero.remove(25);
                            Hero.remove(25);


                            String insertQuery = "INSERT INTO Heroes (Name, SetName, BestWeapon , ReplacementWeapons, BestArtifacts, Sands, Goblet, Circlet, Substats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                            preparedStatement.setString(1, characterName);
                            preparedStatement.setString(2, Hero.get(7));
                            preparedStatement.setString(3, Hero.get(0)); // Замените 1 на индекс нужного столбца
                            preparedStatement.setString(4, Hero.get(1)); // Замените 2 на индекс нужного столбца
                            preparedStatement.setString(5, Hero.get(2));
                            preparedStatement.setString(6, Hero.get(3));
                            preparedStatement.setString(7, Hero.get(4));
                            preparedStatement.setString(8, Hero.get(5));
                            preparedStatement.setString(9, Hero.get(6));
                            preparedStatement.executeUpdate();
                            preparedStatement.setString(1, characterName);
                            preparedStatement.setString(2, Hero.get(16));
                            preparedStatement.setString(3, Hero.get(9)); // Замените 1 на индекс нужного столбца
                            preparedStatement.setString(4, Hero.get(10)); // Замените 2 на индекс нужного столбца
                            preparedStatement.setString(5, Hero.get(11));
                            preparedStatement.setString(6, Hero.get(12));
                            preparedStatement.setString(7, Hero.get(13));
                            preparedStatement.setString(8, Hero.get(14));
                            preparedStatement.setString(9, Hero.get(15));
                            preparedStatement.executeUpdate();
                            preparedStatement.setString(1, characterName);
                            preparedStatement.setString(2, Hero.get(25));
                            preparedStatement.setString(3, Hero.get(18)); // Замените 1 на индекс нужного столбца
                            preparedStatement.setString(4, Hero.get(19)); // Замените 2 на индекс нужного столбца
                            preparedStatement.setString(5, Hero.get(20));
                            preparedStatement.setString(6, Hero.get(21));
                            preparedStatement.setString(7, Hero.get(22));
                            preparedStatement.setString(8, Hero.get(23));
                            preparedStatement.setString(9, Hero.get(24));
                            preparedStatement.executeUpdate();
                        }
                        else {
                            Hero.remove(0);
                            Hero.remove(1);
                            Hero.remove(2);
                            Hero.remove(3);
                            Hero.remove(6);
                            Hero.remove(9);
                            Hero.remove(10);
                            Hero.remove(11);
                            Hero.remove(12);
                            Hero.remove(15);
                            Hero.remove(18);
                            Hero.remove(19);
                            Hero.remove(20);
                            Hero.remove(21);
                            Hero.remove(24);
                            String insertQuery = "INSERT INTO Heroes (Name, SetName, BestWeapon , ReplacementWeapons, BestArtifacts, Sands, Goblet, Circlet, Substats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                            preparedStatement.setString(1, characterName);
                            preparedStatement.setString(2, Hero.get(7));
                            preparedStatement.setString(3, Hero.get(0)); // Замените 1 на индекс нужного столбца
                            preparedStatement.setString(4, Hero.get(1)); // Замените 2 на индекс нужного столбца
                            preparedStatement.setString(5, Hero.get(2));
                            preparedStatement.setString(6, Hero.get(3));
                            preparedStatement.setString(7, Hero.get(4));
                            preparedStatement.setString(8, Hero.get(5));
                            preparedStatement.setString(9, Hero.get(6));
                            preparedStatement.executeUpdate();
                            preparedStatement.setString(1, characterName);
                            preparedStatement.setString(2, Hero.get(16));
                            preparedStatement.setString(3, Hero.get(9)); // Замените 1 на индекс нужного столбца
                            preparedStatement.setString(4, Hero.get(10)); // Замените 2 на индекс нужного столбца
                            preparedStatement.setString(5, Hero.get(11));
                            preparedStatement.setString(6, Hero.get(12));
                            preparedStatement.setString(7, Hero.get(13));
                            preparedStatement.setString(8, Hero.get(14));
                            preparedStatement.setString(9, Hero.get(15));
                            preparedStatement.executeUpdate();
                            preparedStatement.setString(1, characterName);
                            preparedStatement.setString(2, Hero.get(25));
                            preparedStatement.setString(3, Hero.get(18)); // Замените 1 на индекс нужного столбца
                            preparedStatement.setString(4, Hero.get(19)); // Замените 2 на индекс нужного столбца
                            preparedStatement.setString(5, Hero.get(20));
                            preparedStatement.setString(6, Hero.get(21));
                            preparedStatement.setString(7, Hero.get(22));
                            preparedStatement.setString(8, Hero.get(23));
                            preparedStatement.setString(9, Hero.get(24));
                            preparedStatement.executeUpdate();
                        }
                    }
                    else if (Hero.size()>63){
                        Hero.remove(0);
                        Hero.remove(1);
                        Hero.remove(2);
                        Hero.remove(3);
                        Hero.remove(6);
                        Hero.remove(7);
                        Hero.remove(7);
                        Hero.remove(9);
                        Hero.remove(10);
                        Hero.remove(11);
                        Hero.remove(12);
                        Hero.remove(15);
                        Hero.remove(16);
                        Hero.remove(16);
                        Hero.remove(18);
                        Hero.remove(19);
                        Hero.remove(20);
                        Hero.remove(21);
                        Hero.remove(24);
                        Hero.remove(25);
                        Hero.remove(25);
                        Hero.remove(27);
                        Hero.remove(28);
                        Hero.remove(29);
                        Hero.remove(30);
                        Hero.remove(33);
                        Hero.remove(34);
                        Hero.remove(34);

                        String insertQuery = "INSERT INTO Heroes (Name, SetName, BestWeapon , ReplacementWeapons, BestArtifacts, Sands, Goblet, Circlet, Substats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(7));
                        preparedStatement.setString(3, Hero.get(0)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(1)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(2));
                        preparedStatement.setString(6, Hero.get(3));
                        preparedStatement.setString(7, Hero.get(4));
                        preparedStatement.setString(8, Hero.get(5));
                        preparedStatement.setString(9, Hero.get(6));
                        preparedStatement.executeUpdate();
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(16));
                        preparedStatement.setString(3, Hero.get(9)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(10)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(11));
                        preparedStatement.setString(6, Hero.get(12));
                        preparedStatement.setString(7, Hero.get(13));
                        preparedStatement.setString(8, Hero.get(14));
                        preparedStatement.setString(9, Hero.get(15));
                        preparedStatement.executeUpdate();
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(25));
                        preparedStatement.setString(3, Hero.get(18)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(19)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(20));
                        preparedStatement.setString(6, Hero.get(21));
                        preparedStatement.setString(7, Hero.get(22));
                        preparedStatement.setString(8, Hero.get(23));
                        preparedStatement.setString(9, Hero.get(24));
                        preparedStatement.executeUpdate();
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(34));
                        preparedStatement.setString(3, Hero.get(27)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(28)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(29));
                        preparedStatement.setString(6, Hero.get(30));
                        preparedStatement.setString(7, Hero.get(31));
                        preparedStatement.setString(8, Hero.get(32));
                        preparedStatement.setString(9, Hero.get(33));
                        preparedStatement.executeUpdate();
                    }
                    else {
                        Hero.remove(0);
                        Hero.remove(1);
                        Hero.remove(2);
                        Hero.remove(3);
                        Hero.remove(6);
                        String insertQuery = "INSERT INTO Heroes (Name, SetName, BestWeapon , ReplacementWeapons, BestArtifacts, Sands, Goblet, Circlet, Substats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setString(1, characterName);
                        preparedStatement.setString(2, Hero.get(7));
                        preparedStatement.setString(3, Hero.get(0)); // Замените 1 на индекс нужного столбца
                        preparedStatement.setString(4, Hero.get(1)); // Замените 2 на индекс нужного столбца
                        preparedStatement.setString(5, Hero.get(2));
                        preparedStatement.setString(6, Hero.get(3));
                        preparedStatement.setString(7, Hero.get(4));
                        preparedStatement.setString(8, Hero.get(5));
                        preparedStatement.setString(9, Hero.get(6));
                        preparedStatement.executeUpdate();
                    }


                //for(int i = 0; i < Hero.size(); i++){
                //    System.out.println(Hero.get(i));
                //}

                // Закрываем ресурсы
                reader.close();

                executeQuery(getConnection(), "Sands");

                System.out.println("Данные успешно записаны в базу данных.");

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException{

        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties.txt"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void executeQuery(Connection connection, String MainStat) throws SQLException {
//--------------------------------------------(1 set 1 mainstat 4 substat) -----------------------------------------------------------------//
        // Создаем таблицу PerfectArt, если она не существует
        String createTablePerfect = "CREATE TABLE IF NOT EXISTS PerfectArt AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + MainStat + " LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ?";

        PreparedStatement createTableStatement = connection.prepareStatement(createTablePerfect);
        createTableStatement.setString(1, "%Noblesse Oblige%");
        createTableStatement.setString(2, "%ATK%%");
        createTableStatement.setString(3, "%CRIT DMG%");
        createTableStatement.setString(4, "%ATK%%");
        createTableStatement.setString(5, "%CRIT RATE%");
        createTableStatement.setString(6, "%Energy Recharge%");

        createTableStatement.executeUpdate(); // Создаем таблицу

        //--------------------------------------------(1 set 1 mainstat 3 substat) -----------------------------------------------------------------//

        String createTableCompatibility = "CREATE TABLE IF NOT EXISTS Compatibility AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + MainStat + " LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        PreparedStatement createTableCompatibilityStatement = connection.prepareStatement(createTableCompatibility);
        //-----------------------------MainSet----------------------------------------//
        createTableCompatibilityStatement.setString(1, "%Noblesse Oblige%");
        //-----------------------------MainStat----------------------------------------//
        createTableCompatibilityStatement.setString(2, "%ATK%%");
        //-----------------------------SubStats----------------------------------------//
        createTableCompatibilityStatement.setString(3, "%CRIT DMG%");
        createTableCompatibilityStatement.setString(4, "%ATK%%");
        createTableCompatibilityStatement.setString(5, "%CRIT RATE%");
        //
        createTableCompatibilityStatement.setString(6, "%Energy Recharge%");
        createTableCompatibilityStatement.setString(7, "%ATK%%");
        createTableCompatibilityStatement.setString(8, "%CRIT RATE%");
        //
        createTableCompatibilityStatement.setString(9, "%Energy Recharge%");
        createTableCompatibilityStatement.setString(10, "%CRIT DMG%");
        createTableCompatibilityStatement.setString(11, "%CRIT RATE%");
        //
        createTableCompatibilityStatement.setString(12, "%Energy Recharge%");
        createTableCompatibilityStatement.setString(13, "%ATK%%");
        createTableCompatibilityStatement.setString(14, "%CRIT DMG%");

        createTableCompatibilityStatement.executeUpdate(); // Создаем таблицу

        createTableCompatibilityStatement.close();

        //--------------------------------------------(1 set 1 mainstat 2 substat) -----------------------------------------------------------------//

        String sqlSelectQuery = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND Sands LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        String sqlInsertQuery = "INSERT INTO Compatibility SELECT DISTINCT * FROM (" + sqlSelectQuery + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement = connection.prepareStatement(sqlInsertQuery)) {
            // Установка параметров
            CompatibilitypreparedStatement.setString(1, "%Noblesse Oblige%");
            CompatibilitypreparedStatement.setString(2, "%ATK%%");
            CompatibilitypreparedStatement.setString(3, "%CRIT RATE%");
            CompatibilitypreparedStatement.setString(4, "%CRIT DMG%");
            CompatibilitypreparedStatement.setString(5, "%CRIT RATE%");
            CompatibilitypreparedStatement.setString(6, "%Energy Recharge%");
            CompatibilitypreparedStatement.setString(7, "%CRIT RATE%");
            CompatibilitypreparedStatement.setString(8, "%ATK%%");
            CompatibilitypreparedStatement.setString(9, "%CRIT DMG%");
            CompatibilitypreparedStatement.setString(10, "%Energy Recharge%");
            CompatibilitypreparedStatement.setString(11, "%CRIT DMG%");
            CompatibilitypreparedStatement.setString(12, "%ATK%%");
            CompatibilitypreparedStatement.setString(13, "%Energy Recharge%");
            CompatibilitypreparedStatement.setString(14, "%ATK%%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //--------------------------------------------(1 set 1 mainstat 1 substat) -----------------------------------------------------------------//
        // Создаем таблицу PerfectArt, если она не существует
        String createTableSoSO = "CREATE TABLE IF NOT EXISTS SoSo AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + MainStat + " LIKE ? " +
                "AND (" +
                "Substats LIKE ? " +
                "OR Substats LIKE ? " +
                "OR Substats LIKE ? " +
                "OR Substats LIKE ?" +
                ")";

        PreparedStatement createTableStatementSoSO = connection.prepareStatement(createTableSoSO);
        createTableStatementSoSO.setString(1, "%Noblesse Oblige%");
        createTableStatementSoSO.setString(2, "%ATK%%");
        createTableStatementSoSO.setString(3, "%CRIT DMG%");
        createTableStatementSoSO.setString(4, "%ATK%%");
        createTableStatementSoSO.setString(5, "%CRIT RATE%");
        createTableStatementSoSO.setString(6, "%Energy Recharge%");

        createTableStatementSoSO.executeUpdate(); // Создаем таблицу

        //--------------------------------------------(0 set 1 mainstat 4 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_1 = "SELECT * FROM Heroes " +
                "WHERE " + MainStat + " LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ?";

        String sqlInsertQuery_1 = "INSERT INTO SoSo SELECT DISTINCT * FROM (" + sqlSelectQuery_1 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_1 = connection.prepareStatement(sqlInsertQuery_1)) {
            // Установка параметров
            CompatibilitypreparedStatement_1.setString(1, "%ATK%%");
            CompatibilitypreparedStatement_1.setString(2, "%CRIT RATE%");
            CompatibilitypreparedStatement_1.setString(3, "%CRIT DMG%");
            CompatibilitypreparedStatement_1.setString(4, "%Energy Recharge%");
            CompatibilitypreparedStatement_1.setString(5, "%ATK%%");


            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
