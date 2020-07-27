package com.mera.lesson7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueExample {


    public static void main(String[] args) {
       /* Queue<Integer> numbers = new LinkedList<>();

        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);


        final Integer poll = numbers.peek();
        System.out.println(poll);

        System.out.println(numbers);*/


        BlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>(5);
        blockingQueue.add(5);
        blockingQueue.add(-1);
        blockingQueue.add(-1);
        blockingQueue.add(42);
        if (blockingQueue.offer(1)) {
            System.out.println("Добавли элемент");
        } else {
            System.out.println("Очередь полна");
        }

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());


    }
}
