package com.mera.lesson7;

import java.util.concurrent.ThreadLocalRandom;

public enum ColorEnum {
    GREEN("зеленый"),
    RED("красный"),
    YELLOW("желтый");

    private String color;

    ColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static ColorEnum [] VALUES = values();
    public static int SIZE = VALUES.length;

    public static ColorEnum generateRandomColor() {
        return VALUES[ThreadLocalRandom.current().nextInt(SIZE)];
    }
}
