package com.mera.lesson8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorsSample {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        final Class<Person> personClass = (Class<Person>) Class.forName("com.mera.lesson8.Person");
        final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);

        final Object vasya = constructor.newInstance("Vasya", 18);
        System.out.println(vasya);


        final Constructor<?>[] constructors = personClass.getConstructors();
        System.out.println("Всего конструкторов" + constructors.length);
        for (Constructor<?> constrtc : constructors) {
            if (constrtc.getParameterCount() == 0) {
                final Object o = constrtc.newInstance();
                final Person anotherPerson = (Person) o;
                anotherPerson.setAge(22);
                anotherPerson.setName("Petya");
                System.out.println(anotherPerson);
            }

        }

    }
}
