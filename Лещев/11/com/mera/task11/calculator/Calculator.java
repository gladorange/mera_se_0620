package com.mera.task11.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String, Operation> operationMap = new HashMap<>();

    public void calculate(String operationName, Double number1, Double number2) throws CalculatorException {
        if(number1 == null || number2 == null) {
            throw new CalculatorException("Null values in input.", new NullPointerException());
        }
        Operation implementation = operationMap.get(operationName);
        if(implementation == null) {
            throw new CalculatorException("Operation \"" + operationName + "\" not found.");
        }
        try {
            Double result = implementation.doOperation(number1, number2);
            System.out.println(String.format("%s(%.4f, %.4f) -> %f", operationName, number1, number2, result));
        }
        catch (ArithmeticException exception) {
            throw new CalculatorException("Operation failed because of arithmetic exception.", exception);
        }
    }

    public void addOperation(String operationName, Operation implementation) {
        if(operationName == null || implementation == null) {
            throw new IllegalArgumentException("Operation with null name or implementation is not allowed.");
        }
        operationMap.put(operationName, implementation);
    }
}
