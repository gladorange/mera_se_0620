package com.mera.lection3;

public abstract class Animal {
    public static final String DEFAULT_NAME = "Barsik";

    protected int countOfEatenItems = 0;
    protected String name;
    protected boolean full;
    protected Boolean someBool = false;

    public Animal() {
    }


    public abstract String getFavoriteMeal();


    public Animal(String name) {
        this.name = name;
    }

    public boolean isFull() {
        return full;
    }

    public Boolean getSomeBool() {
        return someBool;
    }

    public Animal(int countOfEatenItems, String name) {
        this.countOfEatenItems = countOfEatenItems;
        this.name = name;
    }

    public int getCountOfEatenItems() {
        return countOfEatenItems;
    }

    public void setCountOfEatenItems(int countOfEatenItems) {
        this.countOfEatenItems = countOfEatenItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

