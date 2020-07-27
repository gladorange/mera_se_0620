package com.mera.lesson7;

import java.nio.MappedByteBuffer;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Apple extends FoodItem {
    public static String[] GREEN_SORTS = {"Семеринка", "Белый налив", "Гренни смит"};
    public static String[] RED_SORTS = {"RED DELISHIES", "Глостер"};
    public static String[] YELLOW_SORTS = {"Антоновка", "Голден"};

    protected ColorEnum color;

    public Apple(String name, int price, int calories, int expiryDate, ColorEnum color) {
        super(name, price, calories, expiryDate);
        this.color = color;
    }

    public ColorEnum getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;
        Apple apple = (Apple) o;
        return (price == apple.getPrice()) &&
                name.equals(apple.getName()) &&
                (calories == apple.getCalories()) &&
                (expiryDate == apple.getExpiryDate()) &&
                (color == apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, calories, expiryDate, color);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color.getColor() +
                ", calories=" + calories +
                ", expiryDate=" + expiryDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Apple createRandomApple() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        String name = "";
        ColorEnum colorType = ColorEnum.generateRandomColor();

        switch (colorType) {
            case RED -> name = RED_SORTS[rand.nextInt(RED_SORTS.length)];
            case GREEN -> name = GREEN_SORTS[rand.nextInt(GREEN_SORTS.length)];
            case YELLOW -> name = YELLOW_SORTS[rand.nextInt(YELLOW_SORTS.length)];
        }
        return new Apple(name,rand.nextInt(50, 100), rand.nextInt(40, 80), 30, colorType);
    }
}
