package com.mera.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.function.Supplier;

public class ExecutorServiceExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                final Thread thread = new Thread(r);
                thread.setName("Поток вычислитель");
                return thread;
            }
        });


        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Future<Integer> submit = service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(2000L);
                    System.out.println("Число готово!");
                    return new Random().nextInt(10);
                }
            });

            results.add(submit);
        }

        System.out.println("Потоки запущены");


        final Future<Integer> integerFuture = results.get(0);

        while (!integerFuture.isDone()) {
            System.out.println("Ждем результат!");
        }


        System.out.println("Результат готов" + integerFuture.get());

        service.shutdown();


    }
}
