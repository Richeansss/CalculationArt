package com.example.colculationart;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static void main(String[] args) throws Exception {
        // Создаем словарь с идентификаторами персонажей и комментариями
        Map<String, String> characterIDs = new HashMap<>();
        characterIDs.put("312182", "Albedo");
        characterIDs.put("383712", "Alhaitham");
        characterIDs.put("337957", "Aloy");
        characterIDs.put("297535", "Amber");
        characterIDs.put("345514", "Ayato");
        characterIDs.put("314348", "Baizhu");
        characterIDs.put("297517", "Barbara");
        characterIDs.put("297528", "Beidou");
        characterIDs.put("297522", "Bennett");
        characterIDs.put("386384", "Candace");
        characterIDs.put("297532", "Chongyun");
        characterIDs.put("382079", "Collei");
        characterIDs.put("315233", "Cyno");
        characterIDs.put("383716", "Dehya");
        characterIDs.put("297518", "Diluc");
        characterIDs.put("305872", "Diona");
        characterIDs.put("380569", "Dori");
        characterIDs.put("328764", "Eula");
        characterIDs.put("391897", "Faruzan");
        characterIDs.put("297524", "Fischl");
        characterIDs.put("417207", "Freminet");
        characterIDs.put("312173", "Ganyu");
        characterIDs.put("336726", "Gorou");
        characterIDs.put("345516", "Heizou");
        characterIDs.put("314347", "Hu Tao");
        characterIDs.put("345461", "Itto");
        characterIDs.put("297536", "Jean");
        characterIDs.put("297516", "Kaeya");
        characterIDs.put("386489", "Kaveh");
        characterIDs.put("332826", "Kazuha");
        characterIDs.put("297534", "Keqing");
        characterIDs.put("409556", "Kirara");
        characterIDs.put("297521", "Klee");
        characterIDs.put("337140", "Kokomi");
        characterIDs.put("386486", "Layla");
        characterIDs.put("297515", "Lisa");
        characterIDs.put("345879", "Lynette");
        characterIDs.put("345540", "Lyney");
        characterIDs.put("390096", "Mika");
        characterIDs.put("297526", "Mona");
        characterIDs.put("383713", "Nahida");
        characterIDs.put("383715", "Nilou");
        characterIDs.put("297529", "Ningguang");
        characterIDs.put("297523", "Noelle");
        characterIDs.put("297533", "Qiqi");
        characterIDs.put("337161", "Raiden");
        characterIDs.put("297519", "Razor");
        characterIDs.put("314177", "Rosaria");
        characterIDs.put("336727", "Sara");
        characterIDs.put("333496", "Sayu");
        characterIDs.put("346620", "Shenhe");
        characterIDs.put("346199", "Shinobu");
        characterIDs.put("297525", "Sucrose");
        characterIDs.put("305862", "Tartaglia");
        characterIDs.put("337141", "Thoma");
        characterIDs.put("382082", "Tighnari");
        characterIDs.put("297537", "Traveler (Anemo)");
        characterIDs.put("381807", "Traveler (Dendro)");
        characterIDs.put("336865", "Traveler (Electro)");
        characterIDs.put("297538", "Traveler (Geo)");
        characterIDs.put("416602", "Traveler (Hydro)");
        characterIDs.put("297520", "Venti");
        characterIDs.put("309656", "Wanderer");
        characterIDs.put("297530", "Xiangling");
        characterIDs.put("297527", "Xiao");
        characterIDs.put("297531", "Xingqiu");
        characterIDs.put("305873", "Xinyan");
        characterIDs.put("327533", "Yae Miko");
        characterIDs.put("328765", "Yanfei");
        characterIDs.put("314174", "Yaoyao");
        characterIDs.put("372781", "Yelan");
        characterIDs.put("333497", "Yoimiya");
        characterIDs.put("314345", "Yun Jin");
        characterIDs.put("305858", "Zhongli");
        // Добавьте остальные идентификаторы и комментарии по вашему выбору

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
                            Elements rowCells = row.select("td, th");
                            for (Element cell : rowCells) {
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

                System.out.println("Таблицы и их заголовки успешно сохранены в файл: " + outputFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
