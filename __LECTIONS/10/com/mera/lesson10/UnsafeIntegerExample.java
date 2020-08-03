package com.mera.lesson10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeIntegerExample {


    static AtomicInteger counter = new AtomicInteger(0);


    static class AddToListThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
            super.run();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final AddToListThread addToListThread = new AddToListThread();
        addToListThread.start();
        final AddToListThread addToListThread1 = new AddToListThread();
        addToListThread1.start();
        addToListThread.join();
        addToListThread1.join();
        System.out.println(counter.get());

    }




}
