package com.mera.lesson8;

import java.util.Objects;

@XmlTypeName("Животное")
public class Animal {
    public static final String EMPTY_STRING = "";

    protected String name;
    protected String meal;

    public Animal() {
        name = EMPTY_STRING;
        meal = EMPTY_STRING;
    }

    public Animal(String name, String meal) {
        this.name = name;
        this.meal = meal;
    }

    public String getName() {
        return name;
    }

    public String getMeal() {
        return meal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", meal='" + meal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(meal, animal.meal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, meal);
    }
}
