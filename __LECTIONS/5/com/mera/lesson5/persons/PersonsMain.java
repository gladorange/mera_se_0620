package com.mera.lesson5.persons;

import com.mera.lesson5.persons.Person.IncorrectNameException;

public class PersonsMain {


    public static void main(String[] args)  {
        Person p = new Person("Vasya", "Pupkin");
        try {
            Person p2 = new Person("Вася", "Pupkin");
        } catch (IncorrectNameException e) {
            System.out.println("Неправильное имя :" + e.incorrectName);
        }
        System.out.println(p);
    }
}
