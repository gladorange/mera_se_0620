package com.mera.lesson7;

public class Box<T>  {
    T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }



    public static class NullSafeBox<T> extends Box<T> {

        public NullSafeBox(T content) {
            super(content);
            if (content == null) {
                throw new NullPointerException();
            }
        }


    }

    public static void main(String[] args) {


        Box<Integer> intBox = new Box<>(42);
        Box<String> stringBOx = new NullSafeBox<>("some string");

        System.out.println(intBox.getContent());
        System.out.println(stringBOx.getContent());
    }
}
