package ru.test;

import com.mera.lesson3.Person;

public class ClassFromAnotherPackage {


    public static void main(String[] args) {
        Person vasya = new Person("Vasya","Pupkin");
        vasya.printHello();
    }
}
