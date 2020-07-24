package com.mera.lesson6;

import java.util.Comparator;
import java.util.TreeSet;

import com.mera.lesson6.SetsExample.Person;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ComparatorExample {


    static class PersonWithAge extends Person implements Comparable<PersonWithAge> {
        final int age;
        public PersonWithAge(String name, int age) {
            super(name);
            this.age = age;
        }

        @Override
        public String toString() {
            return "PersonWithAge{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(PersonWithAge o) {
            return age - o.age;
        }
    }


    public static void main(String[] args) {

/*

        final Comparator<PersonWithAge> comparator = new Comparator<PersonWithAge>() {

            @Override
            public int compare(PersonWithAge o1, PersonWithAge o2) {
                return o1.age - o2.age;
            }
        };
*/



        TreeSet<PersonWithAge> sortedPerson = new TreeSet<>();
        //TreeSet<PersonWithAge> sortedPerson = new TreeSet<>(comparator);

        sortedPerson.add(new PersonWithAge("Vasya", 18));
        sortedPerson.add(new PersonWithAge("Petya", 19));
        sortedPerson.add(new PersonWithAge("Oleg Nikolaevich", 54));
        sortedPerson.add(new PersonWithAge("Masha", 12));


        System.out.println(sortedPerson);

    }


}
