package com.mera.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteExample {


    public static void main(String[] args) {
        List<List<String>> someList = new ArrayList<>();
        someList.add(Arrays.asList("a","b"));
        someList.add(Arrays.asList("1", "2"));
    }


    public static void removeListWithLetters(List<List<? extends String>> list) {


        for (List<? extends String> strings : list) {
            if (strings.contains("a")) {
                list.contains(1L);
            }

        }

    }
}
