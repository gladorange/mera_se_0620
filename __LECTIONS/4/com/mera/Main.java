package com.mera;

import static com.mera.another.Person.DEFAULT_NAME;

import com.mera.another.Person;
import com.mera.another.Person.Animal;

public class Main {


    public static void main(String[] args) {
        Person p = new Person(DEFAULT_NAME, "Pupkin", new Animal("Brasik", "Milk"));

        System.out.println(p);

    }
}
