package com.mera.lesson10;

public class SingletonExample {


    volatile private static SingletonExample instance;

    private static final Object monitor = new Object();

    private SingletonExample() {
        System.out.println("Создаю экземпляр");
    }


    public static SingletonExample getInstance() {

        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new SingletonExample();
                }
            }
        }

        return instance;
    }


    public void doWork() {
        System.out.println("Делаю полезную работу");
    }

    private  static void init() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
