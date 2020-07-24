package com.mera.lesson7;

import java.util.HashMap;
import java.util.Map;

public class MethodParametrization {


    public static void main(String[] args) {

        final Map<String, String> stringStringMap = wrapElementsToMap("Вася", "Иванов");
        final Map<String, Integer> ageMap = wrapElementsToMap("Вася", 4);

    }


    public static <K,V> Map<K,V> wrapElementsToMap(K key, V value) {
        Map<K, V> result = new HashMap<>();
        result.put(key, value);
        return result;
    }

}
