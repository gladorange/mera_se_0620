package com.mera.lesson3;

public class StaticVariables {

    public static void main(String[] args) {

        System.out.println("main");

        Person.printHelp();
        Person p = new Person("Vasya");
        p.printHello();
        Person.DEFAULT_SURNAME = "Петров";

      //  Person.DEFAULT_SURNAME = "Петров";
        Person p2 = new Person("Vasya");


        p2.printHello();




    }
}
