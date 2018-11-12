package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, String> countries = new HashMap<>();

    public static void main(String[] args) {
        loadCountries();
    }

    private static void loadCountries() {
        File fileCountries = new File(System.getProperty("user.dir"), "Countries.txt");

        if (fileCountries.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader( new FileReader(fileCountries));

                String[] values;

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    values = line.split(":");
                    String country = values[0];
                    String city = values[1];

                    countries.put(country, city);
                }

                System.out.println("===Список стран и городов===");
                for (HashMap.Entry<String, String> itrStr : countries.entrySet()) {
                    System.out.println(itrStr.getKey() + ": " + itrStr.getValue());
                }

                displayGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл не найден");
            System.out.println("Директория: " + System.getProperty("user.dir"));
        }
    }

    private static void displayGame() {
        System.out.println();
        System.out.println();
        System.out.println("Для выхода из игры напишите 0 и нажмите Enter");
        System.out.println("Напиши столицу данной страны");

        String city = "";
        int score = 0;

        while (!city.equals("0")) {
            String realCity = getRandomCountry();
            Scanner scanner = new Scanner(System.in);
            city = scanner.next();

            if (city.equals("0")) {
                break;
            }

            if (city.equals(realCity)) {
                System.out.println("Успех");

                score++;
            } else {
                System.out.println("Провал");
            }
        }

        System.out.println("Игра завершена");
        System.out.println("Ваш счет: " + score);
    }

    private static String getRandomCountry() {
        String country = "Германия";

        System.out.println(country);

        return countries.get(country);
    }
}