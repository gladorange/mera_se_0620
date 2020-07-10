package com.mera.lesson6;

public class SimpleBox<T> {
    T item;

    void putItem(T item) {
        System.out.println("Кладу в коробку " + item);
        this.item = item;
    }

    public T getItem() {
        return item;
    }


    public static void main(String[] args) {
        SimpleBox<Integer> integerBox = new SimpleBox<>();
        integerBox.putItem(42);


        final Integer item = integerBox.getItem();
        System.out.println(item.longValue());


        SimpleBox<String> stringBox = new SimpleBox<>();
        stringBox.putItem("Какая-то строка");


        final String item2 = stringBox.getItem();
        System.out.println(item2.toUpperCase());


        SimpleBox raw = new SimpleBox();
        raw.putItem("244");
        final String rawItem = (String)raw.getItem();
        System.out.println(rawItem.substring(1));



    }
}
