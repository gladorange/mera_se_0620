package com.lesson9;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileExample {


    public static void main(String[] args) throws IOException {
        File file = new File("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt");
        if (!file.exists()) {
            System.out.println("Файла нет");
            return;
        }


        readSlowFile(file);
        readFastFile(file);
    }

    private static void readSlowFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);


        long counter = 0;
        int read = 0;


        final long start = System.currentTimeMillis();


        byte[] firstLetters = new byte[20_000];

        while ( (read = fileInputStream.read(firstLetters)) != -1) {
            counter++;
        }


        System.out.println("Всего символов в тексте" + counter);
        System.out.println("Это заняло " + (System.currentTimeMillis() - start));

        System.out.println("Последние 20000 символов" + new String(firstLetters));
    }
    private static void readFastFile(File file) throws IOException {
        InputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));


        long counter = 0;
        int read = 0;


        final long start = System.currentTimeMillis();


        byte[] firstLetters = new byte[100];

        while ( (read = fileInputStream.read()) != -1) {
            if (counter < 100) {
                firstLetters[(int) counter] = (byte) read;
            }
            counter++;
        }

        System.out.println("\n Быстрое чтение" + counter);

        System.out.println("Всего символов в тексте" + counter);
        System.out.println("Первые 100 символов" + new String(firstLetters));
        System.out.println("Это заняло " + (System.currentTimeMillis() - start));
    }
}
