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

                //executeQuery(getConnection(), "Sands");

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

    public static void executeQuery(Connection connection, String bestArtifact, String artifactType, String mainStat, String subStat1, String subStat2, String subStat3, String subStat4) throws SQLException {
//--------------------------------------------(1 set 1 mainstat 4 substat) -----------------------------------------------------------------//
        // Создаем таблицу PerfectArt, если она не существует
        String createTablePerfect = "CREATE TABLE IF NOT EXISTS PerfectArt AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ?";

        PreparedStatement createTableStatement = connection.prepareStatement(createTablePerfect);
        createTableStatement.setString(1, "%" + bestArtifact + "%");

        createTableStatement.setString(2, "%" + mainStat + "%");

        createTableStatement.setString(3, "%" + subStat1 + "%");
        createTableStatement.setString(4, "%" + subStat2 + "%");
        createTableStatement.setString(5, "%" + subStat3 + "%");
        createTableStatement.setString(6, "%" + subStat4 + "%");

        createTableStatement.executeUpdate(); // Создаем таблицу

        //--------------------------------------------(1 set 1 mainstat 3 substat) -----------------------------------------------------------------//

        String createTableCompatibility = "CREATE TABLE IF NOT EXISTS Compatibility AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        PreparedStatement createTableCompatibilityStatement = connection.prepareStatement(createTableCompatibility);
        //-----------------------------MainSet----------------------------------------//
        createTableCompatibilityStatement.setString(1, "%" + bestArtifact + "%");
        //-----------------------------MainStat----------------------------------------//
        createTableCompatibilityStatement.setString(2, "%" + mainStat + "%");
        //-----------------------------SubStats----------------------------------------//
        createTableCompatibilityStatement.setString(3, "%" + subStat1 + "%");
        createTableCompatibilityStatement.setString(4, "%" + subStat2 + "%");
        createTableCompatibilityStatement.setString(5, "%" + subStat3 + "%");
        //
        createTableCompatibilityStatement.setString(6, "%" + subStat4 + "%");
        createTableCompatibilityStatement.setString(7, "%" + subStat2 + "%");
        createTableCompatibilityStatement.setString(8, "%" + subStat3 + "%");
        //
        createTableCompatibilityStatement.setString(9, "%" + subStat4 + "%");
        createTableCompatibilityStatement.setString(10, "%" + subStat1 + "%");
        createTableCompatibilityStatement.setString(11, "%" + subStat3 + "%");
        //
        createTableCompatibilityStatement.setString(12, "%" + subStat4 + "%");
        createTableCompatibilityStatement.setString(13, "%" + subStat2 + "%");
        createTableCompatibilityStatement.setString(14, "%" + subStat1 + "%");

        createTableCompatibilityStatement.executeUpdate(); // Создаем таблицу

        createTableCompatibilityStatement.close();

        //--------------------------------------------(1 set 1 mainstat 2 substat) -----------------------------------------------------------------//

        String sqlSelectQuery = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " LIKE ? " +  // Added space after MainStat
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
            CompatibilitypreparedStatement.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement.setString(3, "%" + subStat3 + "%");
            CompatibilitypreparedStatement.setString(4, "%" + subStat1 + "%");

            CompatibilitypreparedStatement.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement.setString(6, "%" + subStat4 + "%");

            CompatibilitypreparedStatement.setString(7, "%" + subStat3 + "%");
            CompatibilitypreparedStatement.setString(8, "%" + subStat2 + "%");

            CompatibilitypreparedStatement.setString(9, "%" + subStat1 + "%");
            CompatibilitypreparedStatement.setString(10, "%" + subStat4 + "%");

            CompatibilitypreparedStatement.setString(11, "%" + subStat1 + "%");
            CompatibilitypreparedStatement.setString(12, "%" + subStat2 + "%");

            CompatibilitypreparedStatement.setString(13, "%" + subStat4 + "%");
            CompatibilitypreparedStatement.setString(14, "%" + subStat2 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //--------------------------------------------(1 set 1 mainstat 1 substat) -----------------------------------------------------------------//
        String createTableSoSO = "CREATE TABLE IF NOT EXISTS SoSo AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND (" +
                "Substats LIKE ? " +
                "OR Substats LIKE ? " +
                "OR Substats LIKE ? " +
                "OR Substats LIKE ?" +
                ")";

        PreparedStatement createTableStatementSoSO = connection.prepareStatement(createTableSoSO);
        createTableStatementSoSO.setString(1, "%" + bestArtifact + "%");

        createTableStatementSoSO.setString(2, "%" + mainStat + "%");

        createTableStatementSoSO.setString(3, "%" + subStat1 + "%");
        createTableStatementSoSO.setString(4, "%" + subStat2 + "%");
        createTableStatementSoSO.setString(5, "%" + subStat3 + "%");
        createTableStatementSoSO.setString(6, "%" + subStat4 + "%");

        createTableStatementSoSO.executeUpdate(); // Создаем таблицу

        //--------------------------------------------(0 set 1 mainstat 4 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_1 = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ?";

        String sqlInsertQuery_1 = "INSERT INTO Compatibility SELECT DISTINCT * FROM (" + sqlSelectQuery_1 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_1 = connection.prepareStatement(sqlInsertQuery_1)) {
            // Установка параметров
            CompatibilitypreparedStatement_1.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_1.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_1.setString(3, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_1.setString(4, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_1.setString(5, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_1.setString(6, "%" + subStat2 + "%");


            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_1.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        //--------------------------------------------(0 set 1 mainstat 3 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_2 = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_2 = "INSERT INTO SoSo SELECT DISTINCT * FROM (" + sqlSelectQuery_2 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_2 = connection.prepareStatement(sqlInsertQuery_2)) {
            // Установка параметров
            //-----------------------------Set---------------------------------------------//
            CompatibilitypreparedStatement_2.setString(1, "%" + bestArtifact + "%");

            //-----------------------------MainStat----------------------------------------//
            CompatibilitypreparedStatement_2.setString(2, "%" + mainStat + "%");
            //-----------------------------SubStats----------------------------------------//
            CompatibilitypreparedStatement_2.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_2.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_2.setString(5, "%" + subStat3 + "%");
            //
            CompatibilitypreparedStatement_2.setString(6, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_2.setString(7, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_2.setString(8, "%" + subStat3 + "%");
            //
            CompatibilitypreparedStatement_2.setString(9, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_2.setString(10, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_2.setString(11, "%" + subStat3 + "%");
            //
            CompatibilitypreparedStatement_2.setString(12, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_2.setString(13, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_2.setString(14, "%" + subStat1 + "%");

            CompatibilitypreparedStatement_2.executeUpdate(); // Создаем таблицу

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //--------------------------------------------(0 set 1 mainstat 2 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_3 = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_3 = "INSERT INTO SoSo SELECT DISTINCT * FROM (" + sqlSelectQuery_3 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_3 = connection.prepareStatement(sqlInsertQuery_3)) {
            // Установка параметров
            CompatibilitypreparedStatement_3.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_3.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_3.setString(3, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_3.setString(4, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_3.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_3.setString(6, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_3.setString(7, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_3.setString(8, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_3.setString(9, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_3.setString(10, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_3.setString(11, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_3.setString(12, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_3.setString(13, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_3.setString(14, "%" + subStat2 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//--------------------------------------------(1 set 0 mainstat 4 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_4 = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ? " +
                "AND Substats LIKE ?";

        String sqlInsertQuery_4 = "INSERT INTO SoSo SELECT DISTINCT * FROM (" + sqlSelectQuery_4 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_4 = connection.prepareStatement(sqlInsertQuery_4)) {
            CompatibilitypreparedStatement_4.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_4.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_4.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_4.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_4.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_4.setString(6, "%" + subStat4 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_4.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------(1 set 0 mainstat 3 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_5 = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_5 = "INSERT INTO SoSo SELECT DISTINCT * FROM (" + sqlSelectQuery_5 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_5 = connection.prepareStatement(sqlInsertQuery_5)) {
            // Установка параметров
            //-----------------------------Set-----------------------------------------------//
            CompatibilitypreparedStatement_5.setString(1, "%" + bestArtifact + "%");
            //-----------------------------Stat-----------------------------------------------//
            CompatibilitypreparedStatement_5.setString(2, "%" + mainStat + "%");
            //-----------------------------SubStats----------------------------------------//
            CompatibilitypreparedStatement_5.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_5.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_5.setString(5, "%" + subStat3 + "%");
            //
            CompatibilitypreparedStatement_5.setString(6, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_5.setString(7, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_5.setString(8, "%" + subStat3 + "%");
            //
            CompatibilitypreparedStatement_5.setString(9, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_5.setString(10, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_5.setString(11, "%" + subStat3 + "%");
            //
            CompatibilitypreparedStatement_5.setString(12, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_5.setString(13, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_5.setString(14, "%" + subStat1 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_5.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //--------------------------------------------(0 set 0 mainstat 1 substat) -----------------------------------------------------------------//
        // Создаем таблицу PerfectArt, если она не существует
        String createTableBad = "CREATE TABLE IF NOT EXISTS Bad AS " +
                "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats NOT LIKE ? AND Substats NOT LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ?) OR " +
                "(Substats NOT LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ?) OR " +
                "(Substats NOT LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ? AND Substats NOT LIKE ?) OR " +
                "(Substats LIKE ? AND Substats NOT LIKE ? AND Substats NOT LIKE ? AND Substats NOT LIKE ?)" +
                ")";

        PreparedStatement createTableStatementBad = connection.prepareStatement(createTableBad);
        createTableStatementBad.setString(1, "%" + bestArtifact + "%");

        createTableStatementBad.setString(2, "%" + mainStat + "%");

        createTableStatementBad.setString(3, "%" + subStat1 + "%");
        createTableStatementBad.setString(4, "%" + subStat2 + "%");
        createTableStatementBad.setString(5, "%" + subStat3 + "%");
        createTableStatementBad.setString(6, "%" + subStat4 + "%");

        createTableStatementBad.setString(7, "%" + subStat1 + "%");
        createTableStatementBad.setString(8, "%" + subStat2 + "%");
        createTableStatementBad.setString(9, "%" + subStat3 + "%");
        createTableStatementBad.setString(10, "%" + subStat4 + "%");

        createTableStatementBad.setString(11, "%" + subStat1 + "%");
        createTableStatementBad.setString(12, "%" + subStat2 + "%");
        createTableStatementBad.setString(13, "%" + subStat3 + "%");
        createTableStatementBad.setString(14, "%" + subStat4 + "%");

        createTableStatementBad.setString(15, "%" + subStat1 + "%");
        createTableStatementBad.setString(16, "%" + subStat2 + "%");
        createTableStatementBad.setString(17, "%" + subStat3 + "%");
        createTableStatementBad.setString(18, "%" + subStat4 + "%");

        createTableStatementBad.executeUpdate();


        //--------------------------------------------(0 set 0 mainstat 2 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_7 = "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats NOT LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats NOT LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ?) OR " +
                "(Substats NOT LIKE ? AND Substats LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ?) OR " +
                "(Substats LIKE ? AND Substats NOT LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ? AND Substats NOT LIKE ?)" +
                ")";

        String sqlInsertQuery_7 = "INSERT INTO Bad SELECT DISTINCT * FROM (" + sqlSelectQuery_7 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_7 = connection.prepareStatement(sqlInsertQuery_7)) {
            CompatibilitypreparedStatement_7.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_7.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_7.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_7.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_7.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_7.setString(6, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_7.setString(7, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_7.setString(8, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_7.setString(9, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_7.setString(10, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_7.setString(11, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_7.setString(12, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_7.setString(13, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_7.setString(14, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_7.setString(15, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_7.setString(16, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_7.setString(17, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_7.setString(18, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_7.setString(19, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_7.setString(20, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_7.setString(21, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_7.setString(22, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_7.setString(23, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_7.setString(24, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_7.setString(25, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_7.setString(26, "%" + subStat4 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_7.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------(0 set 0 mainstat 3 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_8 = "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats NOT LIKE ? AND Substats LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats NOT LIKE ? AND Substats LIKE ? AND Substats NOT LIKE ?)" +
                ")";

        String sqlInsertQuery_8 = "INSERT INTO Bad SELECT DISTINCT * FROM (" + sqlSelectQuery_8 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_8 = connection.prepareStatement(sqlInsertQuery_8)) {
            CompatibilitypreparedStatement_8.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_8.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_8.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_8.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_8.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_8.setString(6, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_8.setString(7, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_8.setString(8, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_8.setString(9, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_8.setString(10, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_8.setString(11, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_8.setString(12, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_8.setString(13, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_8.setString(14, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_8.setString(15, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_8.setString(16, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_8.setString(17, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_8.setString(18, "%" + subStat4 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_8.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------(0 set 0 mainstat 4 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_9 = "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats LIKE ?) AND " +
                "(Substats LIKE ?) AND " +
                "(Substats LIKE ?) AND " +
                "(Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_9 = "INSERT INTO Bad SELECT DISTINCT * FROM (" + sqlSelectQuery_9 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_9 = connection.prepareStatement(sqlInsertQuery_9)) {
            CompatibilitypreparedStatement_9.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_9.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_9.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_9.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_9.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_9.setString(6, "%" + subStat4 + "%");


            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_9.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------(1 set 0 mainstat 2 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_10 = "SELECT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?) OR " +
                "(Substats LIKE ? AND Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_10 = "INSERT INTO SoSo SELECT DISTINCT * FROM (" + sqlSelectQuery_10 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_10 = connection.prepareStatement(sqlInsertQuery_10)) {
            // Установка параметров
            CompatibilitypreparedStatement_10.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_10.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_10.setString(3, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_10.setString(4, "%" + subStat1 + "%");

            CompatibilitypreparedStatement_10.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_10.setString(6, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_10.setString(7, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_10.setString(8, "%" + subStat2 + "%");

            CompatibilitypreparedStatement_10.setString(9, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_10.setString(10, "%" + subStat4 + "%");

            CompatibilitypreparedStatement_10.setString(11, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_10.setString(12, "%" + subStat2 + "%");

            CompatibilitypreparedStatement_10.setString(13, "%" + subStat4 + "%");
            CompatibilitypreparedStatement_10.setString(14, "%" + subStat2 + "%");

            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_10.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------(1 set 0 mainstat 1 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_11 = "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts LIKE ? " +
                "AND " + artifactType + " NOT LIKE ? " +
                "AND (" +
                "(Substats LIKE ?) OR " +
                "(Substats LIKE ?) OR " +
                "(Substats LIKE ?) OR " +
                "(Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_11 = "INSERT INTO Bad SELECT DISTINCT * FROM (" + sqlSelectQuery_11 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_11 = connection.prepareStatement(sqlInsertQuery_11)) {
            CompatibilitypreparedStatement_11.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_11.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_11.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_11.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_11.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_11.setString(6, "%" + subStat4 + "%");


            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_11.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------(0 set 1 mainstat 1 substat) -----------------------------------------------------------------//

        String sqlSelectQuery_12 = "SELECT DISTINCT * FROM Heroes " +
                "WHERE BestArtifacts NOT LIKE ? " +
                "AND " + artifactType + " LIKE ? " +
                "AND (" +
                "(Substats LIKE ?) OR " +
                "(Substats LIKE ?) OR " +
                "(Substats LIKE ?) OR " +
                "(Substats LIKE ?)" +
                ")";

        String sqlInsertQuery_12 = "INSERT INTO Bad SELECT DISTINCT * FROM (" + sqlSelectQuery_12 + ") AS SelectedHeroes";

        try (PreparedStatement CompatibilitypreparedStatement_12 = connection.prepareStatement(sqlInsertQuery_12)) {
            CompatibilitypreparedStatement_12.setString(1, "%" + bestArtifact + "%");

            CompatibilitypreparedStatement_12.setString(2, "%" + mainStat + "%");

            CompatibilitypreparedStatement_12.setString(3, "%" + subStat1 + "%");
            CompatibilitypreparedStatement_12.setString(4, "%" + subStat2 + "%");
            CompatibilitypreparedStatement_12.setString(5, "%" + subStat3 + "%");
            CompatibilitypreparedStatement_12.setString(6, "%" + subStat4 + "%");


            // Выполнение запроса на вставку
            CompatibilitypreparedStatement_12.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
