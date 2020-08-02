package com.mera.lesson10;


public class DeadLockExample {
    static Object oneMonitor = new Object();
    static Object anotherMonitor = new Object();


    public static void main(String[] args) throws InterruptedException {
        final LockAnotherThenOneThread firstThread = new LockAnotherThenOneThread();
        firstThread.start();
        final LockOneThenAnotherThread secndThread = new LockOneThenAnotherThread();
        secndThread.start();
        System.out.println("Конец main");
    }

    static class LockOneThenAnotherThread extends Thread{
        @Override
        public void run() {

            synchronized (oneMonitor) {
              //  lockTwoMonitors("Поток 1");
                System.out.println("Поток 1:Один монитор захвачен");
                try {
                    Thread.sleep(1000);
                    synchronized (anotherMonitor) {
                        System.out.println("Оба монитора захвачены");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    static synchronized void lockTwoMonitors(String threadName) {
        synchronized (oneMonitor) {
            System.out.println(threadName + ":Один монитор захвачен");
            try {
                Thread.sleep(1000);
                synchronized (anotherMonitor) {
                    System.out.println(threadName + ": Оба монитора захвачены");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class LockAnotherThenOneThread extends Thread{
        @Override
        public void run() {
         //   lockTwoMonitors("Поток 2");

            synchronized (anotherMonitor) {
                System.out.println("Поток 2:Один монитор захвачен");
                try {
                    Thread.sleep(1000);
                    synchronized (oneMonitor) {
                        System.out.println("Оба монитора захвачены");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }





}
