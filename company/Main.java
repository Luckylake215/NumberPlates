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

        for (int i = 1; i < 200; i++) {
            for (String x : chars) {
                for (String y : chars) {
                    for (String z : chars) {
                        for ( int j = 1; j < 8; j++) {
                            String format = String.format("%s%03d%s%s%03d", x, j * 111, y, z, i);
                            System.out.println(format);
                            a.add(format);
                            h.add(format);
                            t.add(format);
                        }
                    }
                }
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
