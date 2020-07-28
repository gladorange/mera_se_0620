package com.mera.lesson7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class AppleGarden {
    public static void fillShopWithApples(Collection<? super Apple> shop) {
        int numApples = ThreadLocalRandom.current().nextInt(1, 6);
        Set<ColorEnum> colors = new HashSet<>();
        System.out.println("В магазин добавлены яблоки: " + numApples + "шт");
        for (int i = 0; i < numApples; i++) {
            Apple appleToAdd  = Apple.createRandomApple();
            System.out.println(appleToAdd);
            shop.add(appleToAdd);
            colors.add(appleToAdd.getColor());
        }
        System.out.println("Цвета яблок:");
        colors.forEach(color-> System.out.println(color.getColor()));
    }
}
