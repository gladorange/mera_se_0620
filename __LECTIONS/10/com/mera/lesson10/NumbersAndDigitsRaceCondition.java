package com.mera.lesson10;

import java.io.FileWriter;
import java.io.IOException;

public class NumbersAndDigitsRaceCondition {

    static FileWriter fileWriter;

    // TODO add synchronized modifier or block here
    static Thread printLetterThread = new Thread() {
        @Override
        public void run() {
            char[] letters = {'a','b','c','d','e','f','g','h'};
            for (char letter : letters) {
                try {
                    fileWriter.write(letter);
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    };

    // TODO add synchronized here
    static Runnable printDigitThread = new Runnable() {
        @Override
        public void run() {
            char[] letters = {'1','2','3','4','5','6','7','8'};
            for (char digit : letters) {
                try {
                    fileWriter.write(digit);
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    };


    public static void main(String[] args) throws InterruptedException, IOException {
        fileWriter = new FileWriter("digits and letters.txt");

        printLetterThread.start();
        new Thread(printDigitThread).start();
    }
}
