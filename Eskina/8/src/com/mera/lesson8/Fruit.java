package com.mera.lesson8;

import java.util.Objects;

@XmlTypeName("Фрукт")
public class Fruit {
    public static final String EMPTY_STRING = "";

    @XmlName("тип фрукта")
    String type;
    @XmlName("цвет")
    String color;

    public Fruit() {
    }

    public Fruit(String type, String color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(type, fruit.type) &&
                Objects.equals(color, fruit.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
