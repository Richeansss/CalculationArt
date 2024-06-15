package com.example.colculationart.test;

public class TestCharacterisitcs {

    public static double calculateValue(int baseStat, int level) {
        // Таблица множителей для 4-звездочных персонажей
        double[] multipliers4Star = {
                1.000, 1.083, 1.165, 1.248, 1.330, 1.413, 1.495, 1.578, 1.661, 1.743,
                1.826, 1.908, 1.991, 2.073, 2.156, 2.239, 2.321, 2.404, 2.486, 2.569,
                2.651, 2.734, 2.817, 2.899, 2.982, 3.064, 3.147, 3.229, 3.312, 3.394,
                3.477, 3.560, 3.642, 3.725, 3.807, 3.890, 3.972, 4.055, 4.138, 4.220,
                4.303, 4.385, 4.468, 4.550, 4.633, 4.716, 4.798, 4.881, 4.963, 5.046,
                5.128, 5.211, 5.294, 5.376, 5.459, 5.541, 5.624, 5.706, 5.789, 5.872,
                5.954, 6.037, 6.119, 6.202, 6.284, 6.367, 6.450, 6.532, 6.615, 6.697,
                6.780, 6.862, 6.945, 7.028, 7.110, 7.193, 7.275, 7.358, 7.440, 7.523,
                7.606, 7.688, 7.771, 7.853, 7.936, 8.018, 8.101, 8.183, 8.266, 8.349
        };



        // Проверка, чтобы не выйти за границы массива
        if (level < 1 || level > multipliers4Star.length) {
            throw new IllegalArgumentException("Уровень выходит за допустимые границы");
        }

        // Получаем множитель для указанного уровня
        double value = multipliers4Star[level - 1];

        // Расчет статистики на уровне n
        double stat = baseStat * value;

        System.out.println( Math.ceil((stat + calculateTotalSection(2805.64, level))));

        // Округляем до целого числа
        return stat;
    }

    public static double calculateTotalSection(double total, int level) {
        double totalSection;

        if (level >= 21 && level <= 40) {
            totalSection = (total / 182) * 38.0;
        } else if (level >= 41 && level <= 50) {
            totalSection = (total / 182) * 65.0;;
        } else if (level >= 51 && level <= 60) {
            totalSection = (total / 182) * 101.0;
        } else if (level >= 61 && level <= 70) {
            totalSection = (total / 182) * 128.0;
        } else if (level >= 71 && level <= 80) {
            totalSection = (total / 182) * 155.0;
        } else if (level >= 81 && level <= 90) {
            totalSection = total;
        } else {
            throw new IllegalArgumentException("Уровень выходит за допустимые границы (1-90)");
        }

        return totalSection;
    }

    public static void main(String[] args) {
        // Пример использования метода calculateValue для расчета значения на разных уровнях
        int baseStat = 784; // Пример базовой статистики
        for (int level = 89; level <= 90; level++) {
            double result = calculateValue(baseStat, level);
            System.out.println("Значение на уровне " + level + ": " + result);
        }
    }
}


