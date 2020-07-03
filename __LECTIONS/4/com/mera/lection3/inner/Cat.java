package com.mera.lection3.inner;

import com.mera.lection3.Animal;

public class Cat extends Animal {


    @Override
    public String getFavoriteMeal() {
        return "Рыбка";
    }

    public Cat(String name) {
        super(name);
    }


    public void takeFish() {
        System.out.println("Кот по имени " + name + " съел рыбку. Количество съеденных рыбок " + (++countOfEatenItems));
    }

}
