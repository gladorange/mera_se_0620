package com.mera.lesson7;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Refrigerator extends ElectronicItem {
    public static String[] NAMES_FRIDGE = {"Liebherr", "LG", "Whirpool", "Атлант", "Stinol"};

    protected  int freezerCapacity;

    public Refrigerator(String name, int price, int power, int freezerCapacity) {
        super(name, price, power);
        this.freezerCapacity = freezerCapacity;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "freezerCapacity=" + freezerCapacity +
                ", power=" + power +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Refrigerator)) return false;
        Refrigerator that = (Refrigerator) o;
        return (power == that.getPower()) &&
                (price == that.getPrice()) &&
                (freezerCapacity == that.getFreezerCapacity()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, price, freezerCapacity);
    }

    public static Refrigerator createRandomRefrigerator() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        return new Refrigerator(NAMES_FRIDGE[rand.nextInt(NAMES_FRIDGE.length)], rand.nextInt(15000, 85000),
                rand.nextInt(60, 150), rand.nextInt(50, 100));
    }
}
