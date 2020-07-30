package com.mera.lesson7;

import java.util.concurrent.ThreadLocalRandom;

public enum FoodEnum {
    APPLE,
    BREAD;

    public static FoodEnum [] VALUES = values();
    public static int SIZE = VALUES.length;

    public static FoodEnum generateRandomFoodType() {
        return VALUES[ThreadLocalRandom.current().nextInt(SIZE)];
    }
}
