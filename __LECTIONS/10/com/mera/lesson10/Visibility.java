package com.mera.lesson10;

public class Visibility extends Thread{

    volatile boolean keepRunning = true;

    public void run() {
        long count=0;
        while (keepRunning) {
            count++;
        }

        System.out.println("Thread terminated." + count);
    }

    public static void main(String[] args) throws InterruptedException {
        Visibility t = new Visibility();
        t.start();
        Thread.sleep(1000);
        System.out.println("after sleeping in main");

        t.keepRunning = false;

        t.join();
        System.out.println("keepRunning set to " + t.keepRunning);
    }
}