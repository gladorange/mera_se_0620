package com.lesson9.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ReadFiels {


    public static void main(String[] args) throws IOException {

        final Path path = Paths.get("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt");

        final List<String> strings = Files.readAllLines(path);


        System.out.println(strings.size());
        System.out.println(strings.get(101));



        final String allContent = new String(Files.readAllBytes(path));

        System.out.println(allContent.length());
        System.out.println(allContent);

    }
}
