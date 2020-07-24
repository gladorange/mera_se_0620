package com.mera.lection3.inner;

import java.util.Random;

import com.mera.lection3.Animal;
import com.mera.lection3.Dog;

public class AnimalMain {

    public static void main(String[] args) {
        Cat c = new Cat("Barsik");
        c.takeFish();
        c.takeFish();
        c.takeFish();
        c.takeFish();

        Dog d = new Dog("Sharik");
        d.takeBone();
        d.takeBone();
        d.takeBone();
        d.takeBone();


        Animal animal = getAnimal();
        System.out.println(animal.getName());
        System.out.println(animal.getFavoriteMeal());

        final boolean isCat = animal instanceof Cat;
        if (isCat) {
            final Cat cat = (Cat) animal;
            cat.takeFish();
        }


    }

    private static Animal getAnimal() {
        if (new Random().nextBoolean()) {
            return new Dog("Sharik");
        }
        return new Cat("Vasiliy");
    }


}
