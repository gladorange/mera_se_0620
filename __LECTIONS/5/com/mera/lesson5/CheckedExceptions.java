package com.mera.lesson5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions {


    public static void main(String[] args) {
        try {
            String str = getStringFromFile();
            System.out.println(str);
        } catch (IOException e){
            System.out.println("Файла нет, создаю новый");
        }
    }

    private static String getStringFromFile() throws IOException {
            final FileReader file = new FileReader("f22ile.txt");
            char[] content = new char[5];
            final int read = file.read(content);
            return new String(content);


    }
    /*
    private static String getStringFromFile() {
        try {
            final FileReader file = new FileReader("file.txt");
            char[] content = new char[5];
            final int read = file.read(content);
            return new String(content);
        } catch (IOException e) {
            System.out.println("Файл не найден, возвращаю пустую строку");
            return "";
        }

    }*/
}
