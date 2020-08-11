package com.mera.lesson10;

public class ThreadStop {


    static Object monitor = new Object();

    static String answer;

    static volatile boolean shouldBeStopped = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting");
        Thread t = new Thread(() -> {
            System.out.println("Another thread is started and waiting 2000ms");

            final long start = System.currentTimeMillis();



            synchronized (monitor) {
                while (System.currentTimeMillis() - start < 2000) {
                    if (shouldBeStopped) {
                        answer = "21";
                        return;
                    }
                }
                answer = "42";
            }


            System.out.println("After 2000 ms");
        });


        t.start();
        Thread.sleep(100);
      //  t.stop();
        shouldBeStopped = true;

        synchronized (monitor) {
            System.out.println(answer.length());
        }

        System.out.println("End of main after 100ms");
    }

}
