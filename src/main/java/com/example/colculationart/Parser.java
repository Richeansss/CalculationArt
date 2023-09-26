package com.example.colculationart;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static void main(String[] args) throws Exception {
        // Создаем список заголовков, которые хотим искать
        List<String> targetIDs = new ArrayList<>();
        targetIDs.add("315215"); //Ayaka
        targetIDs.add("312182"); //Albedo
        targetIDs.add("383712"); //Alhaitham
        targetIDs.add("337957"); //Aloy
        targetIDs.add("297535"); //Amber
        targetIDs.add("345514"); //Ayato
        targetIDs.add("314348"); //Baizhu
        targetIDs.add("297517"); //Barbara
        targetIDs.add("297528"); //Beidou
        targetIDs.add("297522"); //Bennett
        targetIDs.add("386384"); //Candace
        targetIDs.add("297532"); //Chongyun
        targetIDs.add("382079"); //Collei
        targetIDs.add("315233"); //Cyno
        targetIDs.add("383716"); //Dehya
        targetIDs.add("297518"); //Diluc
        targetIDs.add("305872"); //Diona
        targetIDs.add("380569"); //Dori
        targetIDs.add("328764"); //Eula
        targetIDs.add("391897"); //Faruzan
        targetIDs.add("297524"); //Fischl
        targetIDs.add("417207"); //Freminet
        targetIDs.add("312173"); //Ganyu
        targetIDs.add("336726"); //Gorou
        targetIDs.add("345516"); //Heizou
        targetIDs.add("314347"); //Hu Tao
        targetIDs.add("345461"); //Itto
        targetIDs.add("297536"); //Jean
        targetIDs.add("297516"); //Kaeya
        targetIDs.add("386489"); //Kaveh
        targetIDs.add("332826"); //Kazuha
        targetIDs.add("297534"); //Keqing
        targetIDs.add("409556"); //Kirara
        targetIDs.add("297521"); //Klee
        targetIDs.add("337140"); //Kokomi
        targetIDs.add("386486"); //Layla
        targetIDs.add("297515"); //Lisa
        targetIDs.add("345879"); //Lynette
        targetIDs.add("345540"); //Lyney
        targetIDs.add("390096"); //Mika
        targetIDs.add("297526"); //Mona
        targetIDs.add("383713"); //Nahida
        targetIDs.add("383715"); //Nilou
        targetIDs.add("297529"); //Ningguang
        targetIDs.add("297523"); //Noelle
        targetIDs.add("297533"); //Qiqi
        targetIDs.add("337161"); //Raiden
        targetIDs.add("297519"); //Razor
        targetIDs.add("314177"); //Rosaria
        targetIDs.add("336727"); //Sara
        targetIDs.add("333496"); //Sayu
        targetIDs.add("346620"); //Shenhe
        targetIDs.add("346199"); //Shinobu
        targetIDs.add("297525"); //Sucrose
        targetIDs.add("305862"); //Tartaglia
        targetIDs.add("337141"); //Thoma
        targetIDs.add("382082"); //Tighnari
        targetIDs.add("297537"); //Traveler (Anemo)
        targetIDs.add("381807"); //Traveler (Dendro)
        targetIDs.add("336865"); //Traveler (Electro)
        targetIDs.add("297538"); //Traveler (Geo)
        targetIDs.add("416602"); //Traveler (Hydro)
        targetIDs.add("297520"); //Venti
        targetIDs.add("309656"); //Wanderer
        targetIDs.add("297530"); //Xiangling
        targetIDs.add("297527"); //Xiao
        targetIDs.add("297531"); //Xingqiu
        targetIDs.add("305873"); //Xinyan
        targetIDs.add("327533"); //Yae Miko
        targetIDs.add("328765"); //Yanfei
        targetIDs.add("314174"); //Yaoyao
        targetIDs.add("372781"); //Yelan
        targetIDs.add("333497"); //Yoimiya
        targetIDs.add("314345"); //Yun Jin
        targetIDs.add("305858"); //Zhongli

        // Создаем список заголовков, которые хотим искать
        List<String> targetHeaderH3s = new ArrayList<>();
        //targetHeaderH3s.add("Main DPS");
        targetHeaderH3s.add("Ayato Normal Attack Main DPS Build");
        targetHeaderH3s.add("Cryno DPS Build 1");
        targetHeaderH3s.add("Cyno DPS Build 2");
        targetHeaderH3s.add("Dehya Sub-DPS Build");
        targetHeaderH3s.add("Dehya Support Build");
        targetHeaderH3s.add("Dori Support Build - Buffer");
        targetHeaderH3s.add("Dori Support Build - Burst Uptime");
        targetHeaderH3s.add("Dori Support Build - Pure Healer");
        targetHeaderH3s.add("Faruzan Support Build for Swirl");
        targetHeaderH3s.add("Faruzan Support Build Buffer");
        targetHeaderH3s.add("Faruzan C6 Support Build");
        targetHeaderH3s.add("Hu Tao Main DPS Build");
        targetHeaderH3s.add("Arataki Itto Main DPS Build");
        targetHeaderH3s.add("Keqing Aggravate Main DPS Build");
        targetHeaderH3s.add("Keqing Non-Aggravate Main DPS Build");
        targetHeaderH3s.add("Layla Support Build Shield-Bot");
        targetHeaderH3s.add("Layla Sub-DPS Build Cryo and Freeze");
        targetHeaderH3s.add("All Purpose Layla Sub-DPS Build");
        targetHeaderH3s.add("Mika Support Buffer Build");
        targetHeaderH3s.add("Mika Support Healer Build");
        targetHeaderH3s.add("Nahida Sub-DPS and Support Build");
        targetHeaderH3s.add("Nahida Main DPS Build");
        targetHeaderH3s.add("Nilou Sub-DPS Build for Off-Field");
        targetHeaderH3s.add("Nilou Main DPS Build for On-Field");
        targetHeaderH3s.add("Raiden Shogun Build for Main DPS, Sub-DPS and Support");
        targetHeaderH3s.add("Wanderer (Scaramouche) Main DPS Build");
        targetHeaderH3s.add("Wanderer (Scaramouche) DPS Build for Swirl");
        targetHeaderH3s.add("Xiao Main DPS Build");
        targetHeaderH3s.add("Xiao 2PC Main DPS Build");
        targetHeaderH3s.add("Yelan Main DPS Build");
        targetHeaderH3s.add("Yelan Sub-DPS Build");
        targetHeaderH3s.add("Yelan Support Build");

        List<String> targetHeaderH4s = new ArrayList<>();
        targetHeaderH4s.add("Burst Buffer");
        targetHeaderH4s.add("Burgeon Sub-DPS");
        targetHeaderH4s.add("Shielded Support");
        targetHeaderH4s.add("Geo Sub DPS");
        targetHeaderH4s.add("Tenacity Support");
        targetHeaderH4s.add("Solo Dendro DPS");
        targetHeaderH4s.add("Burst Sub-DPS");
        targetHeaderH4s.add("Quickswap Burst Main DPS");
        targetHeaderH4s.add("Pyro Burst Support");
        targetHeaderH4s.add("Dendro Support");
        targetHeaderH4s.add("Full Healer");
        targetHeaderH4s.add("Barbara Dendro Core Build");
        targetHeaderH4s.add("Healer Hybrid Build");
        targetHeaderH4s.add("Electro Main DPS");
        targetHeaderH4s.add("Healer Build");
        targetHeaderH4s.add("Main DPS Build");
        targetHeaderH4s.add("Off-Field Sub-DPS Build");
        targetHeaderH4s.add("Support Buffer Build");
        targetHeaderH4s.add("Cryo Main DPS");
        targetHeaderH4s.add("Cryo Sub DPS");
        targetHeaderH4s.add("Burst Support");
        targetHeaderH4s.add("Burst Sub-DPS Build");
        targetHeaderH4s.add("Pyro Main DPS");
        targetHeaderH4s.add("Alternative Artifact Build");
        targetHeaderH4s.add("Buffer Support");
        targetHeaderH4s.add("Healer Support");
        targetHeaderH4s.add("Physical Main DPS");
        targetHeaderH4s.add("Physical DMG Stack");
        targetHeaderH4s.add("Stanadard Electro Ranged DPS");
        targetHeaderH4s.add("Physical DPS Build");
        targetHeaderH4s.add("Elemental Reaction Sub-DPS");
        targetHeaderH4s.add("Pale Flame Physical");
        targetHeaderH4s.add("Blizzard Strayer Cryo");
        targetHeaderH4s.add("Hybrid DPS");
        targetHeaderH4s.add("Reverse Melt Team Main DPS");
        targetHeaderH4s.add("Freeze Team Main DPS");
        targetHeaderH4s.add("Cryo Sub-DPS");
        targetHeaderH4s.add("Geo Support");
        targetHeaderH4s.add("CRIT DPS");
        targetHeaderH4s.add("Swirl DPS");
        targetHeaderH4s.add("Anemo Sub DPS");
        targetHeaderH4s.add("ATK Buffer Build");
        targetHeaderH4s.add("Freeze Team");
        targetHeaderH4s.add("Physical Support");
        targetHeaderH4s.add("Bloom DPS");
        targetHeaderH4s.add("Bloom Driver");
        targetHeaderH4s.add("Spread Main DPS");
        targetHeaderH4s.add("Anemo Sub-DPS");
        targetHeaderH4s.add("Swirl Support");
        targetHeaderH4s.add("Shield Support");
        targetHeaderH4s.add("Hybrid Support");
        targetHeaderH4s.add("Pyro DPS");
        targetHeaderH4s.add("Debuff Mine Deployer");
        targetHeaderH4s.add("On-Field DPS");
        targetHeaderH4s.add("Hydro Sub-DPS");
        targetHeaderH4s.add("Hydro Support");
        targetHeaderH4s.add("Electro Reaction Sub DPS");
        targetHeaderH4s.add("Swirl Debuffer");
        targetHeaderH4s.add("Burst Damage");
        targetHeaderH4s.add("Geo Main DPS");
        targetHeaderH4s.add("Shield and Healing Support");
        targetHeaderH4s.add("Quickbloom Dendro DPS");
        targetHeaderH4s.add("All-Purpose Support");
        targetHeaderH4s.add("Freeze or All-Purpose Sub-DPS");
        targetHeaderH4s.add("ATK Support");
        targetHeaderH4s.add("Swirl Driver");
        targetHeaderH4s.add("Crit Sub DPS");
        targetHeaderH4s.add("Hyperbloom Build");
        targetHeaderH4s.add("Party Buff Support");
        targetHeaderH4s.add("Swirl Sub DPS");
        targetHeaderH4s.add("Anemo Support");
        targetHeaderH4s.add("Hydro Main DPS");
        targetHeaderH4s.add("Charged Attack Main DPS Build");
        targetHeaderH4s.add("Dendro Reaction Focus Build");
        targetHeaderH4s.add("Dendro Main DPS");
        targetHeaderH4s.add("Dendro Reaction Build");
        targetHeaderH4s.add("Geo Burst Sub DPS");
        targetHeaderH4s.add("All-Purpose Hydro");
        targetHeaderH4s.add("Elemental Mastery Swirl");
        targetHeaderH4s.add("Crit Burst DPS");
        targetHeaderH4s.add("Pyro Sub DPS");
        targetHeaderH4s.add("Hydro Sub DPS");
        targetHeaderH4s.add("Aggravate Sub-DPS");
        targetHeaderH4s.add("Hard-Hitting Skill Sub-DPS");
        targetHeaderH4s.add("Charged Attack DPS");
        targetHeaderH4s.add("Dendro Healer");
        targetHeaderH4s.add("Tenacity Healer");
        targetHeaderH4s.add("Bloom Support");
        targetHeaderH4s.add("Normal Attack Main DPS");
        targetHeaderH4s.add("Pyro Reactions DPS");
        targetHeaderH4s.add("Mix and Match Set");
        targetHeaderH4s.add("Normal ATK Main DPS");

        for(int i=0;i < targetIDs.size();i++) {
            //String targetUrl = "305858";
            String url = "https://game8.co/games/Genshin-Impact/archives/" + targetIDs.get(i);
            Document doc = Jsoup.connect(url).get();
            String outputFilePath ="SoureceDataBase/" + targetIDs.get(i) + ".txt"; // Путь к текстовому файлу для сохранения всех таблиц
            //String outputFilePathhtml = "SoureceDataBase/" + targetUrl + ".html"; // Путь к файлу для сохранения HTML-кода

            try {
                // Открываем файл для записи
                FileWriter writer = new FileWriter(outputFilePath);
                //FileWriter writerr = new FileWriter(outputFilePathhtml);
                //writerr.write(doc.outerHtml());
                //writerr.close();


                for (String targetHeaderH3 : targetHeaderH3s) {
                    // Поиск заголовков
                    Elements headers = doc.select("h3:contains(" + targetHeaderH3 + ")");


                    for (Element header : headers) {
                        // Поиск следующего заголовка
                        Element nextHeader = header.nextElementSibling();

                        // Создаем список для хранения таблиц
                        List<Element> tables = new ArrayList<>();

                        // Поиск и запись таблиц между заголовками
                        while (nextHeader != null && !nextHeader.tagName().startsWith("h")) {
                            if (nextHeader.tagName().equalsIgnoreCase("table")) {
                                tables.add(nextHeader);
                            }
                            nextHeader = nextHeader.nextElementSibling();
                        }

                        // Запись содержимого таблиц в файл
                        for (Element table : tables) {
                            writer.write(targetHeaderH3 + "\n");
                            for (Element row : table.select("tr")) {
                                Elements cells = row.select("td,th");
                                for (Element cell : cells) {
                                    String cellText = cell.text();
                                    writer.write(cellText);
                                    writer.write("\t");
                                }
                                writer.write("\n");
                            }
                            writer.write("\n");
                        }
                    }
                }

                for (String targetHeaderH4 : targetHeaderH4s) {
                    // Поиск заголовков
                    Elements headers = doc.select("h4:contains(" + targetHeaderH4 + ")");

                    for (Element header : headers) {
                        // Поиск следующего заголовка
                        Element nextHeader = header.nextElementSibling();

                        // Создаем список для хранения таблиц
                        List<Element> tables = new ArrayList<>();

                        // Поиск и запись таблиц между заголовками
                        while (nextHeader != null && !nextHeader.tagName().startsWith("h")) {
                            if (nextHeader.tagName().equalsIgnoreCase("table")) {
                                tables.add(nextHeader);
                            }
                            nextHeader = nextHeader.nextElementSibling();
                        }

                        // Запись содержимого таблиц в файл
                        for (Element table : tables) {
                            writer.write(targetHeaderH4 + "\n");
                            for (Element row : table.select("tr")) {
                                Elements cells = row.select("td,th");
                                for (Element cell : cells) {
                                    String cellText = cell.text();
                                    writer.write(cellText);
                                    writer.write("\t");
                                }
                                writer.write("\n");
                            }
                            writer.write("\n");
                        }
                    }
                }

                // Закрываем файл
                writer.close();

                System.out.println("Все таблицы успешно сохранены в файл: " + outputFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
