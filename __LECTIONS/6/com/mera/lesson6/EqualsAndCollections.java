package com.mera.lesson6;

import java.util.HashSet;
import java.util.Objects;

public class EqualsAndCollections {


    static class Animal {
        public String name;

        public Animal(String barsik) {
            name = barsik;
        }

        public boolean equals(Object animal) {
            return name.equals(((Animal) animal).name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashSet<Animal> animals = new HashSet<>();

        animals.add(new Animal("Barsik"));
        animals.add(new Animal("Barsik"));


        System.out.println(animals.size());
        System.out.println(animals);


        HashSet<Animal> anotherAnimals = new HashSet<>();

        final Animal barsik = new Animal("Barsik");
        anotherAnimals.add(barsik);
        barsik.name = "Vaska";

        System.out.println(animals.contains(barsik));



    }
}
