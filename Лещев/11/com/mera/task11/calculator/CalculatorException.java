package com.mera.task11.calculator;

public class CalculatorException extends RuntimeException {

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorException(String message) {
        super(message);
    }
}
