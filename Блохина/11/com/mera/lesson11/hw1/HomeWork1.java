package com.mera.lesson11.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWork1 {
    public static void main(String[] args) {
        List<Person11> person11 = new ArrayList<>();
        person11.add(new Person11("Евгений", 67));
        person11.add(new Person11("Олег", 65));
        person11.add(new Person11("Николай", 73));
        person11.add(new Person11("Андрей", 46));
        person11.add(new Person11("Александр", 54));

        System.out.println("Коллекция персон");
        person11.forEach(System.out::println);

        System.out.println("Сортировка по имени");
        Collections.sort(person11, (person1, person2) -> person1.getName().compareTo(person2.getName()));
        person11.forEach(System.out::println);

        System.out.println("Сортировка по возрасту");
        Collections.sort(person11, (age1, age2) -> Integer.compare(age1.getAge(), age2.getAge()));
        person11.forEach(System.out::println);

    }
}
