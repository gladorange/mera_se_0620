package com.mera.lesson10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableFutureExample {


    public static void main(String[] args) throws InterruptedException {
        final ExecutorService service = Executors.newFixedThreadPool(4);

        final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(1000);
                    return 42;

                } catch (InterruptedException e) {
                    return 0;
                }

            }
        });


        future.thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Число готово" + integer);

            }
        });

        

        Thread.sleep(10000);
    }
}
