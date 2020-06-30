package com.mera.lesson3;

import com.mera.lesson3.Person;

public class Personreferences {


    public static void main(String[] args) {
        Person vasya = new Person("Вася", "Пупкин");

      /*  com.mera.lesson3.Person petya = vasya;
        petya.name = "Петя";*/

        //vasya.printHello();


        changeName(vasya);
        vasya.printHello();

    }



    public static void changeName(Person p) {
        p = new Person("Новое имя", p.surname);
    }
}
