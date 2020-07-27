package com.mera.lesson7;

import java.util.HashMap;
import java.util.Map;

public class MapsExample {

    public static void main(String[] args) {
        Map<String, Integer> lastNameToLength = new HashMap<>();
        lastNameToLength.put("Иванов", "Иванов".length());
        lastNameToLength.put("Петров", "Петров".length());
        lastNameToLength.put("Сидоров", "Сидоров".length());


        System.out.println(lastNameToLength);


        System.out.println(lastNameToLength.keySet());
        System.out.println(lastNameToLength.values());


        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Степанов", "Степанов".length());
        anotherMap.put("Иванов", -1);


        lastNameToLength.putAll(anotherMap);
        System.out.println(lastNameToLength);


    }
}
