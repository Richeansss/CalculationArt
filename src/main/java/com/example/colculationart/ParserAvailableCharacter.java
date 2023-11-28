package com.example.colculationart;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.Map;


public class ParserAvailableCharacter {

    private static final String OUTPUT_FOLDER = "character_images";

    public static void main(String[] args) {
        try {
            // URL страницы с таблицей
            String url = "https://game8.co/games/Genshin-Impact/archives/296707";

            // Получение HTML-кода страницы
            Connection.Response response = Jsoup.connect(url).execute();
            Map<String, String> cookies = response.cookies();
            Document document = response.parse();

            // Находим заголовок "All Playable Characters"
            Element header = document.select("h3:contains(All Playable Characters)").first();

            if (header != null) {
                // Получаем таблицу, следующую за заголовком
                Element table = header.nextElementSibling();

                // Получение всех строк таблицы
                Elements rows = table.select("tr");

                // Создание папки для сохранения изображений
                File outputFolder = new File(OUTPUT_FOLDER);
                outputFolder.mkdir(); // Создаем папку, если ее нет

                // Проход по каждой строке таблицы
                for (Element row : rows) {
                    // Получение ссылок на изображения
                    Elements images = row.select("img[src]");
                    for (Element image : images) {
                        String imageUrl = image.absUrl("src");
                        String altText = image.attr("alt");
                        saveImage(imageUrl, altText, outputFolder, cookies);
                    }
                }
            } else {
                System.out.println("Заголовок не найден");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveImage(String imageUrl, String altText, File outputFolder, Map<String, String> cookies) {
        try {
            if (imageUrl.startsWith("data:")) {
                // Handle data URL
                String base64Data = imageUrl.substring(imageUrl.indexOf(",") + 1);
                byte[] imageData = Base64.getDecoder().decode(base64Data);

                String fileName = altText + ".png";  // Using alt text as the filename
                File outputFile = new File(outputFolder, fileName);

                FileUtils.writeByteArrayToFile(outputFile, imageData);
            } else {
                // Handle regular URL
                if (imageUrl.startsWith("http")) {
                    URL url = new URL(imageUrl);
                    String fileName = altText + ".png";  // Using alt text as the filename
                    File outputFile = new File(outputFolder, fileName);

                    FileUtils.copyURLToFile(url, outputFile, 5000, 5000);
                } else {
                    System.out.println("Unsupported URL format: " + imageUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}