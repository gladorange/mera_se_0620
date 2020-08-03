package com.mera.lesson8;

public class ObjectNotFoundException extends Exception {
    ObjectNotFoundException() {
        super("Object couldn't be deserialized");
    }
}
