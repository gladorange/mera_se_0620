package com.mera.lesson3;

public class Person {



    static {
        System.out.println("Класс com.mera.another.Person загрузился");
    }



    public static String DEFAULT_SURNAME = "Иванов";

    String name;
    String surname;

    {
        System.out.println("блок инициализации, имя: " + name);
    }

    {
        System.out.println("После ");
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name) {
        this.name = name;
        this.surname = DEFAULT_SURNAME;
    }



    public void printHello() {
        System.out.println("Привет, я " + name + " " + surname);
    }

    public void printHello(Person anotherPerson) {
        System.out.println("Привет тебе, " + anotherPerson.name + ", я " + name + " " + surname);
    }

    public static void printHelp() {
        System.out.println("Класс com.mera.another.Person описывает человека с именем и фамилией");
    }

}
