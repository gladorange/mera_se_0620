package com.mera.another;

public class Person {
    public static class Animal {
        String name;
        String favoriteMeal;


        /**
         * This contrutor cretes new instance of Animal
         * @param name name of new animal
         * @param favoriteMeal meal of new animal
         */
        public Animal(String name, String favoriteMeal) {
            this.name = name;
            this.favoriteMeal = favoriteMeal;
        }

        @Override
        public String toString() {
            return "com.mera.another.Animal{" +
                    "name='" + name + '\'' +
                    ", favoriteMeal='" + favoriteMeal + '\'' +
                    '}';
        }
    }



    String name;
    String surname;
    Animal favoriteAnimal;

    public static String DEFAULT_NAME = "Vasya";


    public static void main(String[] args) {
        Person p = new Person("Vasya", "Pupkin", new Animal("Barsik", "Milk"));
        System.out.println(p);
    }


    public Person(String name, String surname, Animal favoriteAnimal) {
        this.name = name;
        this.surname = surname;
        this.favoriteAnimal = favoriteAnimal;
    }


    public String getName() {
        return name != null ? name : "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "com.mera.another.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", favoriteAnimal=" + favoriteAnimal +
                '}';
    }
}
