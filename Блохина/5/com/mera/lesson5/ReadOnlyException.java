package com.mera.lesson5;

public class ReadOnlyException extends Exception {
    public ReadOnlyException() {
        super("Элемент выключен");
    }
}
