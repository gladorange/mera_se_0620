package com.lesson9.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class PathCreate {


    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("C:\\programming\\mera_se_0620\\__LECTIONS\\9");
        final Path tmp = path.resolve("tmp");


        Files.createDirectories(tmp);
        final Path tempDirectory = Files.createTempDirectory(tmp, "_");


        System.out.println(tempDirectory.toAbsolutePath());


        final Path myTmpFile = Files.createTempFile(tmp, "file_", ".tmp");
        final Path defaultTmpFile = Files.createTempFile("file_", ".tmp");


        System.out.println(myTmpFile.toAbsolutePath());
        System.out.println(defaultTmpFile.toAbsolutePath());


    }


}
