package com.mera.lesson8;

public class ClazzSample {


    public static void main(String[] args) {
        Person some = new Person("Vasya", 18);


        Class<? extends Person> aClass = some.getClass();


        descripeClass(aClass);
        descripeClass(" some String".getClass());


    }

    private static void descripeClass(Class<?> aClass) {
        System.out.println(aClass.getName());
        System.out.println(aClass.getTypeName());
        System.out.println(aClass.getSuperclass().getName());
        System.out.println(aClass.getCanonicalName());
        System.out.println(aClass.getPackage().getName());
    }
}
