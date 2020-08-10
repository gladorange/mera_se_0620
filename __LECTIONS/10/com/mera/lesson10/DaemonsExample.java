package com.mera.lesson10;

import java.lang.Thread.UncaughtExceptionHandler;

public class DaemonsExample {


    static Runnable counter = new Runnable() {
        @Override
        public void run() {
            int begin = 0;

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("Прошло " + (++begin) + " секунд");
                //throw new NullPointerException();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(counter);
      //  thread.setDaemon(true);
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(String.format("В потоке %s проищошло исключение %s", t.getName(), e.getClass().getSimpleName()));
            }
        });
        thread.start();
        thread.setName("Поток считатель");
        thread.join();
        System.out.println("main закончился");
    }
}
