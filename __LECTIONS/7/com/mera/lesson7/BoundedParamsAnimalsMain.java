package com.mera.lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BoundedParamsAnimalsMain {


    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }
    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
 static class Fox extends Animal {
        public Fox(String name) {
            super(name);
        }
    }


    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Барсик"));
        cats.add(new Cat("Рыжик"));

        printAnimalNames(cats);
       // addDog(cats);

        System.out.println(cats);


        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Cat("Барсик"));
        zoo.add(new Dog("Шарик"));
        zoo.add(new Fox("Алиса"));
        addDog(zoo);


        List<Object> someObjects = new ArrayList<>();
        someObjects.add(42);
        someObjects.add("Some string");
        addDog(someObjects);


    }


    public static void printAnimalNames(Collection<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.name);
        }
    }

    public static void addDog(Collection<? super Animal> animals) {
        animals.add(new Dog("Шарик"));
    }
}
