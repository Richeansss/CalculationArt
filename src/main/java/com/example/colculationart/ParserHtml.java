package com.example.colculationart;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParserHtml {

    private ProgressBarUpdater progressBarUpdater;

    public void setProgressBarUpdater(ProgressBarUpdater updater) {
        this.progressBarUpdater = updater;
    }

    public static void PerCharacter(ParserHtml parserHtml) {
        HashMap<String, String> characterIDs = HMap.getCharactersID();
        Tables.getConnectionResetAndCreate();
        int totalCharacters = characterIDs.size();
        int currentCharacter = 0;
        for (Map.Entry<String, String> entry : characterIDs.entrySet()) {
            String characterID = entry.getKey();
            String characterName = entry.getValue();

            String url = "https://game8.co/games/Genshin-Impact/archives/" + characterID;
            String outputFilePath = "SoureceDataBase/" + characterName + ".txt"; // Путь к текстовому файлу для сохранения всех таблиц



            try {
                // Получаем HTML-документ с указанного URL
                Document doc = Jsoup.connect(url).get();

                // Открываем файл для записи
                FileWriter writer = new FileWriter(outputFilePath);

                // Поиск таблиц, которые содержат все 3 нужных слова
                Elements tables = doc.select("table");
                for (Element table : tables) {
                    Elements cells = table.select("td, th");
                    String tableText = cells.text();
                    if (tableText.contains("Best Weapon") &&
                            tableText.contains("Best Artifacts") &&
                            tableText.contains("Replacement Weapons")) {
                        // Запись содержимого таблицы в файл
                        for (Element row : table.select("tr")) {
                            for (Element cell : row.select("td, th")) {
                                String cellText = cell.text();
                                writer.write(cellText);
                                writer.write("\t");
                            }
                            writer.write("\n");
                        }

                        // Поиск заголовка над таблицей и запись его в файл
                        Element prevSibling = table.previousElementSibling();
                        if (prevSibling != null && (prevSibling.tagName().equalsIgnoreCase("h3") || prevSibling.tagName().equalsIgnoreCase("h4"))) {
                            String tableTitle = prevSibling.text();
                            writer.write(tableTitle + "\n" + "\n");
                        }
                    }
                }

                // Закрываем файл
                writer.close();

                DataBaseHandler.InsertToDB(characterName);

                System.out.println("Таблицы и их заголовки успешно сохранены в файл: " + outputFilePath);


            } catch (IOException e) {
                e.printStackTrace();
            }



            currentCharacter++;
            double progress = (double) currentCharacter / totalCharacters;
            if (parserHtml.progressBarUpdater != null) {
                parserHtml.progressBarUpdater.updateProgressBar(progress, characterName);
            }
        }
    }
}