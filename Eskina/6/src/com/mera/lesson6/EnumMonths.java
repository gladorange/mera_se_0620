package com.mera.lesson6;

import java.util.Random;

public enum EnumMonths {
    JANUARY("январь", 31),
    FEBRUARY("февраль", 28),
    MARCH("март", 31),
    APRIL("апрель", 30),
    MAY("май", 31),
    JUNE("июнь", 30),
    JULY("июль", 31),
    AUGUST("август", 31),
    SEPTEMBER("сентябрь", 30),
    OCTOBER("октябрь", 31),
    NOVEMBER("ноябрь", 30),
    DECEMBER("декабрь", 31);

    private String name;
    private int days;
    private EnumMonths(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    private static final EnumMonths[] VALUES = values();
    private static final int SIZE = VALUES.length;

    public static EnumMonths generateRandomMonth() {
        Random rand = new Random();
        return VALUES[rand.nextInt(SIZE)];
    }
}
