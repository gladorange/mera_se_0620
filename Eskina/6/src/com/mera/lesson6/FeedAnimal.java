package com.mera.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FeedAnimal {
    public static void main(String[] args) {
        List<Pair<Animal, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(new Animal("кот", "Базилио"), "рыба"));
        pairs.add(new Pair<>(new Animal("лиса", "Алиса"), "мясо"));
        pairs.add(new Pair<>(new Animal("собака", "Артемон"), "косточка"));
        pairs.add(new Pair<>(new Animal("собака", "Артемон"), "косточка"));

        feedAnimal(pairs);

        //check equals work properly
        if(pairs.get(0).equals(pairs.get(1))) {
            System.out.printf("Животное %s равно животному %s\n", pairs.get(0), pairs.get(1));
        } else {
            System.out.printf("Животное %s и животное %s разные!\n", pairs.get(0), pairs.get(1));
        }

        if(pairs.get(2).equals(pairs.get(3))) {
            System.out.printf("Животное %s равно животному %s\n", pairs.get(2), pairs.get(3));
        } else {
            System.out.printf("Животное %s и животное %s разные!\n", pairs.get(2), pairs.get(3));
        }
    }
    public static void feedAnimal(List<Pair<Animal, String >> pairs) {
        //choose one lucky animal for double feed
        int luckyNum = ThreadLocalRandom.current().nextInt(pairs.size());

        //feed all animals from the list
        for(int i = 0; i < pairs.size(); i++) {
            Pair<Animal, String> pair = pairs.get(i);
            if (i == luckyNum) {
                System.out.printf("Счастливо животное %s получает двойную порцию %s\n", pair.getFirst().getName(), pair.getSecond());
            } else {
                System.out.printf("Животное %s с радостью ест %s\n", pair.getFirst().getName(), pair.getSecond());
            }

        }
    }
}
