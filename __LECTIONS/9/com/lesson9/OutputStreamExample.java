package com.lesson9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {



    public static void main(String[] args) throws IOException {


        FileOutputStream fileOutputStream = null;

        try {
             fileOutputStream = new FileOutputStream("file.txt");
            fileOutputStream.write(42);
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }



        try (FileOutputStream anotherStream =  new FileOutputStream("file.txt")) {
            anotherStream.write(84);
        }


    }
}
