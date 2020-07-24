package com.mera.lesson6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Visits {
    public static final String[] places = {"изба", "лес", "поле"};

    public static void main(String[] args) {
        List<Triple<Person, Date, String>> visitList = new ArrayList<>();
        Set<Triple<Person, Date, String>> visitSet = new HashSet<>();

        Person first = new Person("Никита", "Кожемяка");
        Person second = new Person("Алеша", "Попович");
        Person third = new Person("Василиса", "Прекрасная");
        Person forth = new Person("Кощей", "Бессмертный");
        Person fifth = new Person("Баба", "Яга");

        Person[] people = {first, second, third, forth, fifth};

        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < people.length; j++) {
                Triple<Person, Date, String> visit = new Triple<>(people[j], Date.generateRandomDate(), generateRandomPlace());
                visitList.add(visit);
                visitSet.add(visit);
            }

        }
        System.out.printf("\n Лист посещений: %d записей\n\n", visitList.size());
        visitList.forEach(visit-> System.out.println(visit));

        System.out.printf("\n Сет посещений: %d записей\n\n", visitSet.size());
        visitSet.forEach(visit-> System.out.println(visit));

        if (visitList.size() == visitSet.size()) {
            System.out.println("Ни один человек не посещал одно и то же место два раза в один день");
        }
    }

    public static String generateRandomPlace() {
        return places[ThreadLocalRandom.current().nextInt(places.length)];
    }
}
