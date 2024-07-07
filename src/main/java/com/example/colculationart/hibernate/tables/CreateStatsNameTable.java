package com.example.colculationart.hibernate.tables;

import com.example.colculationart.hibernate.dao.weapon.StatsNameDAO;
import com.example.colculationart.hibernate.entity.StatsName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

public class CreateStatsNameTable {

    /**
     * Логгер для записи логов.
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateStatsNameTable.class);

    /**
     * Главный метод, запускающий создание записей в таблице StatsName.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        createStatsName();
    }

    /**
     * Создает записи в таблице StatsName для каждого имени, если запись с таким именем ещё не существует.
     */
    public static void createStatsName() {
        StatsNameDAO statsNameDAO = new StatsNameDAO();

        // Список имен для статов
        List<String> statsNames = Arrays.asList("Elemental Mastery", "CRIT DMG", "ATK%", "Physical DMG Bonus", "CRIT Rate", "Energy Recharge", "HP%", "DEF%");

        // Проверка существования и добавление новых записей
        for (String name : statsNames) {
            if (!statsNameDAO.existsByName(name)) {
                StatsName statsName = new StatsName();
                statsName.setName(name);
                statsNameDAO.addEntity(statsName);
                logger.info("Добавлен стат с именем: {}", name);
            } else {
                logger.info("Стат с именем {} уже существует.", name);
            }
        }
    }
}
