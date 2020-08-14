package hw11;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operationsMap = new HashMap<>();

    public void calculate(String operationName, Double number1, Double number2) throws ArithmeticException, NoSuchMethodException {
        if(!operationsMap.containsKey(operationName)){
            throw new NoSuchMethodException("Операция '"+operationName+"' не реализована");
        }
        System.out.println(operationsMap.get(operationName).doOperation(number1,number2));
    }

    public void addOperation(String operationName, Operation implementation) {
        operationsMap.put(operationName, implementation);
    }
}
