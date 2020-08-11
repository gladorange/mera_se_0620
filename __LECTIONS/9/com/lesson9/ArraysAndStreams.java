package com.lesson9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ArraysAndStreams {


    public static void main(String[] args) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(50);
        stream.write(58);

        System.out.println(Arrays.toString(stream.toByteArray()));


        byte[] array = new byte[2];
        array[0] = 50;
        array[1] = 58;

        System.out.println(array[0] + " " + array[1]);


        ByteArrayInputStream inputStream = new ByteArrayInputStream(stream.toByteArray());

        System.out.println("Читаю из потока");
        int read;
        while ( (read = inputStream.read()) != -1) {
            System.out.println(read);
        }





    }
}
