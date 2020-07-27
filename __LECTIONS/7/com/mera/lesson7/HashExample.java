package com.mera.lesson7;

import java.util.HashMap;
import java.util.Objects;

public class HashExample {


    public static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {


        HashMap<Person, Integer> personToAge = new HashMap<>();

        final Person vasya = new Person("вася");
        personToAge.put(vasya, 18);


        System.out.println(personToAge.containsKey(vasya));


        vasya.name = "Вася";
        personToAge.put(vasya, 42);


        System.out.println(personToAge);


        System.out.println(vasya.hashCode());
        System.out.println(System.identityHashCode(vasya));

    }
}
