package com.mera.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskExecutor implements Runnable {


    List<Runnable> tasks = new ArrayList<>();


    public TaskExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }


    @Override
    public void run() {
        for (Runnable task : tasks) {

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Кто-то меня прервал, заканчиваю выполнение всех задач");
                return;
            }

            task.run();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                    System.out.println("Кто-то меня прервал, заканчиваю выполнение одной задачи");
                    return;
                }
                   /* if (Thread.interrupted()) {
                        System.out.println("Кто-то меня прервал, заканчиваю выполнение одной задачи");
                        return;
                    }
                */


                System.out.println("Задача 1 готова");


            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                final long begin = System.currentTimeMillis();
                while (System.currentTimeMillis() - begin < 3000) {

                }
                System.out.println("Задача 2 готова");

            }
        };

        TaskExecutor example = new TaskExecutor(Arrays.asList(r1, r2));
        final Thread taskThread = new Thread(example);
        taskThread.start();

        Thread.sleep(100);
        taskThread.interrupt();

    }
}
