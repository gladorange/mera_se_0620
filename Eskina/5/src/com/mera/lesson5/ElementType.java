package com.mera.lesson5;

import java.util.Random;

public enum ElementType {
    BUTTON("Кнопка"),
    CHECK_BOX("Галка"),
    TEXT_FIELD("Текстовое поле");

    private String name;
    private ElementType(String name) {
        this.name = name;
    }

    private static final ElementType[] VALUES = values();
    private static final int SIZE = VALUES.length;

    public static ElementType generateRandomType() {
        Random rand = new Random();
        return VALUES[rand.nextInt(SIZE)];
    }

    public String getName() {
        return name;
    }
}
