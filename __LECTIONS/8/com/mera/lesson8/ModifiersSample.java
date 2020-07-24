package com.mera.lesson8;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModifiersSample {


    public static void main(String[] args) {
        System.out.println(Modifier.isInterface(Collection.class.getModifiers()));
        System.out.println(Modifier.isInterface(ModifiersSample.class.getModifiers()));


        List<String> strings = new ArrayList<>();

        final Class<?>[] interfaces = strings.getClass().getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getCanonicalName());
        }

    }
}
