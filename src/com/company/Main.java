package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл не найден");
            System.out.println("Директория: " + System.getProperty("user.dir"));
        }
    }
}