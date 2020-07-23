package com.mera.lesson7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ListIteratorExample {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");


        final Iterator<String> iterator = list.iterator();

        final String next1 = iterator.next();
        final String next2 = iterator.next();
        final String next3 = iterator.next();
        final String next4 = iterator.next();


        System.out.println(next1);
        System.out.println(next2);
        System.out.println(next3);
        System.out.println(next4);

        if (iterator.hasNext()) {
            iterator.next();
        } else {
            System.out.println("элементы закончились");
        }


        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            String s = iter.next();
            System.out.println("Элемент из итератора " + s);
            if  (s.equals("2")) {
                iter.remove();
            }
        }


        System.out.println("Список без двойки:" + list);


        final ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            String s = stringListIterator.next();
            if  (s.equals("3")) {
                stringListIterator.add("2");
            }
        }

        System.out.println("Список c двойкой:" + list);


        final ListIterator<String> reverseIterator = list.listIterator(list.size());
        while (reverseIterator.hasPrevious()) {
            String s = reverseIterator.previous();
            System.out.println("В обратном порядка " + s);
        }


    }
}
