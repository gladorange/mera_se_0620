package com.mera.lesson8;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;



public class FieldsSample {



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Class<Person> personClass = Person.class;

        System.out.println(personClass.getFields().length);
        final Field[] declaredFields = personClass.getDeclaredFields();

        final Person person = personClass.getConstructor().newInstance();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getType() == int.class) {
                declaredField.set(person,42);
            }

            if (declaredField.getType() == String.class) {
                declaredField.set(person, "Anton");
            }

            System.out.println("Обнаружено поле " + declaredField.getName());

        }

        System.out.println(person);


        try {
            final Method setName = personClass.getMethod("setName", String.class);
            setName.invoke(person, "Антон");

        }  catch (InvocationTargetException e) {
            if (e.getCause() instanceof NullPointerException) {
                System.out.println("Случился NPE на строке" + e.getCause().getStackTrace()[0].getLineNumber());
            }
            System.out.println(e.getMessage());
        }


        System.out.println(person);
    }
}
