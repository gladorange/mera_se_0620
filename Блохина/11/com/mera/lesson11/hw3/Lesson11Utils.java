package com.mera.lesson11.hw3;

import java.util.concurrent.ThreadLocalRandom;

public class Lesson11Utils {
    public static int getRandom(int begin, int end){

        return ThreadLocalRandom.current().nextInt(begin, end);
    }

    public static int getRandom(int num){

        return ThreadLocalRandom.current().nextInt(1, num);
    }
}
