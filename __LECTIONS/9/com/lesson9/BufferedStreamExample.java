package com.lesson9;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamExample {


    public static void main(String[] args) throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("another-file.txt"));
        outputStream.write(84);
        outputStream.close();

    }
}
