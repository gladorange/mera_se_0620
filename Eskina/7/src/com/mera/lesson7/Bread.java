package com.mera.lesson7;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Bread extends FoodItem {
    public static String[] NAMES_BREAD = {"ржаной", "батон", "цельнозерновой"};

    protected int weight;

    public Bread(String name, int price, int calories, int expiryDate, int weight) {
        super(name, price, calories, expiryDate);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "weight=" + weight +
                ", calories=" + calories +
                ", expiryDate=" + expiryDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bread)) return false;
        Bread bread = (Bread) o;
        return (price == bread.getPrice()) &&
                name.equals(bread.getName()) &&
                (calories == bread.getCalories()) &&
                (expiryDate == bread.getExpiryDate()) &&
                (weight == bread.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, calories, expiryDate, weight);
    }

    public static Bread createRandomBread() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        String name = NAMES_BREAD[rand.nextInt(NAMES_BREAD.length)];

        return new Bread(name,rand.nextInt(10, 70), rand.nextInt(40, 80), 3, rand.nextInt(150, 300));
    }
}
