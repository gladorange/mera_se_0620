package com.mera.task11.persons;

import java.util.*;

public class PersonCollection {

    public static List<Person> createPersonList() {
        Person vasya = new Person("Vasya", 19);
        Person masha = new Person("Masha", 18);
        Person misha = new Person("Misha", 10);
        Person pertovich = new Person("Ivan Petrovich", 55);
        Person petrovna = new Person("Elizaveta Petrovna", 70);
        Person anna = new Person("Anna", 33);

        return Arrays.asList(vasya, masha, misha, pertovich, petrovna, anna);
    }

    public static void sortByName(List<Person> people) {
        throwExceptionIfNull(people);
        //lambda expression variant
        //Collections.sort(people, ((o1, o2) -> o1.getName().compareTo(o2.getName())));
        //Comparator.comparing + method reference variant
        Collections.sort(people, Comparator.nullsFirst(Comparator.comparing(Person::getName)));
    }

    public static void sortByAge(List<Person> people) {
        throwExceptionIfNull(people);
        Collections.sort(people, Comparator.nullsFirst(Comparator.comparing(Person::getAge)));
    }

    public static void printPersonList(List<Person> people) {
        throwExceptionIfNull(people);
        System.out.println("List of people (name - age):");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
        System.out.println();
    }

    private static void throwExceptionIfNull(List<Person> people) {
        if(people == null) {
            throw new IllegalArgumentException("Invalid person list!");
        }
    }
}
