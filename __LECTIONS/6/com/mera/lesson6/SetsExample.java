package com.mera.lesson6;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetsExample {


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return name;
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
    }


    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("b");


        System.out.println(strings.size());
        System.out.println(strings.toString());


        Set<Person> persons = new HashSet<>();

        persons.add(new Person("Vasya"));
        persons.add(new Person("Vasya"));
        persons.add(new Person("Vasya"));
        persons.add(new Person("Vasya"));
        persons.add(new Person("Vasya"));


        System.out.println(persons.size());
        System.out.println(persons.toString());
    }
}
