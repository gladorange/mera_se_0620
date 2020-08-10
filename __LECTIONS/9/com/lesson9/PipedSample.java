package com.lesson9;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class PipedSample {


    public static void main(String[] args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();

        PipedInputStream input = new PipedInputStream(out);


        out.write("some string".getBytes());


        final byte[] content = new byte[100];
        final int read = input.read(content);


        System.out.println(new String(content));

    }
}
