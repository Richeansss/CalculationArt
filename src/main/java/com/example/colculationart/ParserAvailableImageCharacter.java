package com.example.colculationart;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class ParserAvailableImageCharacter {

    private static final Logger logger = LoggerFactory.getLogger(ParserAvailableImageCharacter.class);
    private static final String OUTPUT_FOLDER = "character_images";

    public static void main(String[] args) {
        try {
            // URL страницы с таблицей
            String url = "https://game8.co/games/Genshin-Impact/archives/296707";

            // Получение HTML-кода страницы
            Connection.Response response = Jsoup.connect(url).execute();
            Map<String, String> cookies = response.cookies();
            Document document = response.parse();

            // Находим таблицу с указанными столбцами
            Elements tables = document.select("table");
            Element targetTable = null;

            for (Element table : tables) {
                Elements headers = table.select("th");
                boolean hasName = headers.stream().anyMatch(th -> "name".equals(th.attr("data-cell")));
                boolean hasElement = headers.stream().anyMatch(th -> "element".equals(th.attr("data-cell")));
                boolean hasWeapon = headers.stream().anyMatch(th -> "weapon".equals(th.attr("data-cell")));
                boolean hasRarity = headers.stream().anyMatch(th -> "rarity".equals(th.attr("data-cell")));

                if (hasName && hasElement && hasWeapon && hasRarity) {
                    targetTable = table;
                    break;
                }
            }

            if (targetTable != null) {
                // Получение всех строк таблицы
                Elements rows = targetTable.select("tr");

                // Создание папки для сохранения изображений
                File outputFolder = new File(OUTPUT_FOLDER);
                if (!outputFolder.exists()) {
                    boolean dirCreated = outputFolder.mkdir(); // Создаем папку, если ее нет
                    if (!dirCreated) {
                        logger.error("Не удалось создать директорию: {}", OUTPUT_FOLDER);
                        return;
                    }
                } // Создаем папку, если ее нет

                // Проход по каждой строке таблицы
                for (Element row : rows) {
                    // Получение ссылок на изображения
                    Elements links = row.select("a.a-link");
                    for (Element link : links) {
                        Element img = link.selectFirst("img");
                        if (img != null) {
                            String imageUrl = img.absUrl("data-src");  // Изменено на data-src
                            String name = link.text().trim();
                            logger.info("Name: {}", name);
                            logger.info("Image URL: {}", imageUrl);

                            saveImage(imageUrl, name, outputFolder, cookies);
                        }
                    }
                }
            } else {
                logger.warn("Таблица с указанными столбцами не найдена");
            }
        } catch (IOException e) {
            logger.error("Ошибка при обработке страницы", e);
        }
    }

    private static void saveImage(String imageUrl, String altText, File outputFolder, Map<String, String> cookies) {
        try {
            String fileName = altText + ".png";  // Using alt text as the filename
            File outputFile = new File(outputFolder, fileName);

            // Проверка, если файл уже существует, пропустить его
            if (outputFile.exists()) {
                logger.info("Файл уже существует: {}", fileName);
                return;
            }

            if (imageUrl.startsWith("data:")) {
                // Handle data URL
                String base64Data = imageUrl.substring(imageUrl.indexOf(",") + 1);
                byte[] imageData = java.util.Base64.getDecoder().decode(base64Data);

                FileUtils.writeByteArrayToFile(outputFile, imageData);
            } else {
                // Handle regular URL
                if (imageUrl.startsWith("http")) {
                    URL url = new URL(imageUrl);

                    FileUtils.copyURLToFile(url, outputFile, 5000, 5000);
                } else {
                    logger.warn("Неподдерживаемый формат URL: {}", imageUrl);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка при сохранении изображения", e);
        }
    }
}
