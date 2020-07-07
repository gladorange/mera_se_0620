package com.mera.lesson5;

public class ExceptionCreation {

    public static void main(String[] args) {
        System.out.println("Создаю NPE");
        final NullPointerException nullPointerException = new NullPointerException();
        System.out.println("Конец");
    }
}
