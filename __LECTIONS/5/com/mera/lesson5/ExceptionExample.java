package com.mera.lesson5;

import java.util.Random;

public class ExceptionExample {


    public static void main(String[] args) {


    /*    try {
            System.out.println(12 / getRandomInt());
            String npeStr = null;
            npeStr.length();
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        } catch (NullPointerException e) {
            System.out.println("ошибка Null на строке " + e.getStackTrace()[0].getLineNumber());
        }*/
        try {
            System.out.println(12 / getRandomInt());
            String npeStr = null;
            npeStr.length();
        }
        catch (Exception e) {
            System.out.println("Произошло какое-то исключение:" + e.getMessage());
        }

        System.out.println("Программа завершилась");
    }

    private static int getRandomInt() {
        return 2;
    }


}
