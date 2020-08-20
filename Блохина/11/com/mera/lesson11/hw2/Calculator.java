package com.mera.lesson11.hw2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    static final Map<String, Operation> operationItems = new HashMap<>();

    public static Double calculate(String operationName, Double number1, Double number2) {
        return operationItems.get(operationName).doOperation(number1, number2);
    }

    public static void addOperation(String operationName, Operation implementation) {
        operationItems.put(operationName, implementation);
    }
}
