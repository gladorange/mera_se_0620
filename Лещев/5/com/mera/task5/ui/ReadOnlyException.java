package com.mera.task5.ui;

public class ReadOnlyException extends RuntimeException {

    public ReadOnlyException(String message) {
        super(message);
    }

    public ReadOnlyException(String message, Throwable cause) {
        super(message, cause);
    }

}
