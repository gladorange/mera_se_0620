package com.mera.lesson7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class FoodFactory {
    public static void fillShopWithFood(Collection<? super FoodItem> shop) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int numberGoods = rand.nextInt(1, 6);
        System.out.println("В магазин добавлены продукты: " + numberGoods + "шт");
        Set<ColorEnum> colors = new HashSet<>();
        int overallWeight = 0;
        for (int i =0; i < numberGoods; i++) {
            FoodItem itemToAdd = createRandomProductItem();
            if (itemToAdd != null){
                if (itemToAdd instanceof Apple) {
                    colors.add(((Apple) itemToAdd).getColor());
                }
                if (itemToAdd instanceof Bread) {
                    overallWeight += ((Bread) itemToAdd).getWeight();
                }
                System.out.println(itemToAdd);
                shop.add(itemToAdd);
            }
        }
        System.out.println("Цвета добавленных яблок: " );
        colors.forEach(colorEnum -> System.out.println(colorEnum.getColor()));
        System.out.println("Общий вес хлеба: " + overallWeight + "г");
    }

    public static FoodItem createRandomProductItem() {
        FoodEnum itemType = FoodEnum.generateRandomFoodType();
        switch (itemType) {
            case BREAD -> {return Bread.createRandomBread();}
            case APPLE ->{return Apple.createRandomApple();}
        }
        return null;
    }
}
