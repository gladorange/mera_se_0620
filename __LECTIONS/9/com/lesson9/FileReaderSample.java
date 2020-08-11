package com.lesson9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderSample {


    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("numbers.txt")) {

            for (int i = 60; i < 100; i++) {
                fos.write(i);
            }
        }


        char[] read = new char[100];
        try (FileReader fr = new FileReader("numbers.txt")) {
            fr.read(read);
        }

        System.out.println(new String(read));


    }
}
