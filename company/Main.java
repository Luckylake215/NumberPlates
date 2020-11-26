package com.company;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        String[] chars = new String[]{"А", "В","Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х", };


        ArrayList<String> a = new ArrayList<>();
        HashSet<String> h = new HashSet<>();
        TreeSet<String> t = new TreeSet<>();

        for (int i = 0; i < chars.length; i++) {
            //первые 2 нуля
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%s%03d%s%02d\n", chars[i], j, chars[i] + chars[i]);
            }

            //буквы и цифры
            for (int j = 111; j <= 999; j += 111) {
                System.out.printf("%s%03d%s%02d\n", chars[i], j, chars[i] + chars[i]);
            }
        }

        //одинаковые цифры
        for (int i = 111; i <= 999; i += 111) {
            for (int j = 0; j < chars.length; j++) {
                for (int j2 = 0; j2 < chars.length; j2++) {
                    for (int k = 0; k < chars.length; k++) {
                        System.out.printf("%s%03d%s%02d\n", chars[j], i, chars[j2] + chars[k]);
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите искомый номер. Для выхода введите пробел");

        while(true) {
            String s = scanner.nextLine();
            if (s.equals(" ")) {
                break;
            } else {
                long start = System.nanoTime();
                boolean b = a.contains(s);
                long time = System.nanoTime() - start;
                System.out.println("Поиск перебором. Номер " + (b ? "найден" : "не найден") + ". Время поиска - " +  time);


                Collections.sort(a);
                start = System.nanoTime();
                Collections.binarySearch(a, s);
                time = System.nanoTime() - start;
                System.out.println("Бинарный поиск. Номер " + (Collections.binarySearch(a, s) >= 0 ? "найден" : "не найден") + ". Время поиска - " +  time);

                start = System.nanoTime();
                b = h.contains(s);
                time = System.nanoTime() - start;
                System.out.println("Поиск в HashSet. Номер " + (b ? "найден" : "не найден") + ". Время поиска - " +  time);

                start = System.nanoTime();
                b = t.contains(s);
                time = System.nanoTime() - start;
                System.out.println("Поиск в HashSet. Номер " + (b ? "найден" : "не найден") + ". Время поиска - " +  time);
            }
        }
    }
}
