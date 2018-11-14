package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static ArrayList<CountryCapital> countryCapitalList = new ArrayList<>();

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
                    String capital = values[1];

                    countryCapitalList.add(new CountryCapital(country, capital));
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
        System.out.println("Для выхода из игры напишите 0 и нажмите Enter");
        System.out.println("Напиши столицу данной страны");

        String writtenCity = "";
        int score = 0;

        while (!writtenCity.equals("0")) {
            CountryCapital currentCountry = getRandomCountry();

            System.out.print("Страна: " + currentCountry.getCountry() + "; Столица: ");

            Scanner scanner = new Scanner(System.in);
            writtenCity = scanner.next();

            if (writtenCity.equals("0")) {
                break;
            }

            if (writtenCity.toLowerCase().equals(currentCountry.getCapital().toLowerCase())) {
                System.out.println("Результат: Верно");
                score++;
            } else {
                System.out.println("Результат: Неверно");
                System.out.println("Ответ - " + currentCountry.getCapital());
            }

            System.out.println();
        }

        System.out.println("Игра завершена");
        System.out.println("Ваш счет: " + score);
    }

    private static CountryCapital getRandomCountry() {
        Random random = new Random();
        int rndIndex = random.nextInt(countryCapitalList.size());

        return countryCapitalList.get(rndIndex);
    }
}