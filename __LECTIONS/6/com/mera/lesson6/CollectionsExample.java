package com.mera.lesson6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(1);
        strings.add("42");
        strings.add("22");
        System.out.println(strings.size());


        for (String string : strings) {
            System.out.println(string);
        }

        final Iterator<String> iterator = strings.iterator();

        final String next = iterator.next();
        final String twentyTwp = iterator.next();

        System.out.println(next);
        System.out.println(twentyTwp);

        if (iterator.hasNext()) {
            iterator.next();
        } else {
            System.out.println("Элементы закончились");
        }


        final Iterator<String> anotherIterator = strings.iterator();

        while (anotherIterator.hasNext()) {
            final String element = anotherIterator.next();

            strings.add("НОвая строка");

            System.out.println("Элемент из интератора" + element);

        }


    }
}
