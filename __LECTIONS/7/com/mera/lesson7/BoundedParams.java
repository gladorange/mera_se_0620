package com.mera.lesson7;

public class BoundedParams {


    static <T extends Comparable<T>> T max(T one, T another) {
        return one.compareTo(another) > 0 ? one : another;
    }


    static  Comparable maxNonGeneric(Comparable one, Comparable another) {
        return one.compareTo(another) > 0 ? one : another;
    }

    public static void main(String[] args) {


        final Integer max = max(42, 1);
        System.out.println(max);

        final Integer anotherMax = max(24, 12);
        System.out.println(anotherMax);

        final Comparable<String> comparable = maxNonGeneric("abc", 42);
        System.out.println(comparable);

    }
}
