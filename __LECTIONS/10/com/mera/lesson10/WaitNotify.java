package com.mera.lesson10;

import java.io.ObjectInputStream;

public class WaitNotify {


    static int number1;
    static int number2;
   static Object monitor = new Object();


    static Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {

            synchronized (monitor) {
                try {
                    Thread.sleep(2000);
                    number1 = 20;
                    number2 = 22;
                    System.out.println("Числа готовы");
                    monitor.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

   static Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {

            System.out.println("Консьюмер запустился");
            synchronized (monitor) {
                try {
                    System.out.println("Консьюмер захватил монитор");
                    monitor.wait();
                    System.out.println("Консьюмер проснулся");
                    System.out.println("Результат сложения это" + (number2+number1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        consumer.start();
        Thread.sleep(100);
        producer.start();





    }

}
