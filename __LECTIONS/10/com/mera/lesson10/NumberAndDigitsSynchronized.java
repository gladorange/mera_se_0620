package com.mera.lesson10;

import java.io.FileWriter;
import java.io.IOException;

public class NumberAndDigitsSynchronized {


    static FileWriter fileWriter;

    public static void main(String[] args) throws IOException {
        fileWriter = new FileWriter("digits and letters synchronized.txt");

        char[] letters = {'a','b','c','d','e','f','g','h'};
        char[] digits = {'1','2','3','4','5','6','7','8'};


        Thread letterThread = new Thread(() -> writeToFile(letters));
        Thread digitThead = new Thread(() -> writeToFile(digits));


        letterThread.start();
        digitThead.start();



    }

    static void writeToFile(char[] symbols) {
        for (char symbol : symbols) {
            try {
                fileWriter.write(symbol);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
