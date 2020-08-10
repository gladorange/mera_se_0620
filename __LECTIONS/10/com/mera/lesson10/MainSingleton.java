package com.mera.lesson10;

public class MainSingleton {


    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonExample.getInstance().doWork();
                }
            }).start();
        }

    }
}
