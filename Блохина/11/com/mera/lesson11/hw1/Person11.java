package com.mera.lesson11.hw1;

public class Person11 {
    private String name;
    private int age;

    public Person11(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person11{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
