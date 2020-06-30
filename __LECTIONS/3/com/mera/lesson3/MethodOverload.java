package com.mera.lesson3;

public class MethodOverload {

    public static void main(String[] args) {
        Person vasya = new Person("Vasya");
        Person petya = new Person("Petya");
        vasya.printHello();
        vasya.printHello(petya);
        vasya.printHello(vasya);
    }
}
