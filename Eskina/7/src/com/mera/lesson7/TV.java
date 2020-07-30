package com.mera.lesson7;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class TV extends ElectronicItem {
    public static String[] NAMES_TV = {"Sony", "Phillips", "Panasonic", "LG", "Daewoo", "Supra"};

    protected int volume;

    public TV(String name, int price, int power, int volume) {
        super(name, price, power);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TV)) return false;
        TV tv = (TV) o;
        return (power == tv.getPower()) &&
                (price == tv.getPrice()) &&
                (volume == tv.getVolume()) &&
                Objects.equals(getName(), tv.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, price, volume);
    }

    @Override
    public String toString() {
        return "TV{" +
                "volume=" + volume +
                ", power=" + power +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static TV createRandomTV() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        return new TV(NAMES_TV[rand.nextInt(NAMES_TV.length)], rand.nextInt(5000, 55000),
                rand.nextInt(60, 150), rand.nextInt(50, 100));
    }
}
