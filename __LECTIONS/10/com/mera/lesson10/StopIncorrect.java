package com.mera.lesson10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StopIncorrect {



    public static void main(String[] args) throws InterruptedException {


        FileContentHolder fh = new FileContentHolder();
        Thread t = new Thread(() -> fh.tryInit());
        t.start();
        Thread.sleep(500);
        t.interrupt();
        t.join();
        if (fh.initDone) {
            System.out.println(fh.content);
        } else {
            System.out.println("Не иинициализирован");
        }





    }

   static class FileContentHolder {
       String content;
       boolean initDone = false;


        synchronized void tryInit() {
            try {
                FileReader fr = new FileReader("digits and letters.txt");
                char[] buffer = new char[10];


                int i = 0;
                int read = fr.read();
                buffer[i++] = (char) read;
                while (read!= -1) {

                    if (Thread.interrupted()) {
                        fr.close();
                        System.out.println("Я закрываюсь");
                        return;
                    }
                    buffer[i++] = (char) read;
                    read = fr.read();
                    final long start = System.currentTimeMillis();
                    Thread.sleep(100);

                }

                fr.read(buffer);
                fr.close();
                initDone = true;

                content = new String(buffer);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
