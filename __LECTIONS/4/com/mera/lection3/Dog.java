package com.mera.lection3;

public class Dog extends Animal {

    public void takeBone() {
        System.out.println("Собака по имени " + name + " съела косточку. Количество съеденных косточек " + (++countOfEatenItems));
    }

    @Override
    public String getFavoriteMeal() {
        return "косточка";
    }

    public Dog(String name) {
        super(name);
    }
}

