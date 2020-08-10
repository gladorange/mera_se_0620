package com.lesson9.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsSample {


    public static void main(String[] args) {

        final Path path = Paths.get("file.txt");


        final Path rootDirectory = Paths.get("");
        System.out.println(rootDirectory.resolve(path).toAbsolutePath());
    }
}
