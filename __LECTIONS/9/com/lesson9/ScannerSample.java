package com.lesson9;

import java.util.Scanner;

public class ScannerSample {


    static class Person {
        String name;
        String surname;
        int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {

        Person p = new Person();

        Scanner s = new Scanner(System.in);

        System.out.println("Введите имя:\n");
        final String name = s.next();

        System.out.println("Введите фамилию:\n");
        final String surname = s.next();

        System.out.println("Введите возраст:\n");
        final int age = s.nextInt();

        p.name = name;
        p.surname = surname;
        p.age = age;

        System.out.println(p);
    }


}
