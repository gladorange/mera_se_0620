package com.mera.lesson11.hw2;

public class HomeWork2 {
    public static void main(String[] args) {
        Double number1 = 100d;
        Double number2 = 2d;

        Calculator calculator = new Calculator();
        calculator.addOperation("multiplication", (a, b) -> a * b);
        calculator.addOperation("division", (a, b) -> a / b);
        calculator.addOperation("sum", (a, b) -> a + b);
        calculator.addOperation("difference", (a, b) -> a - b);
        calculator.addOperation("exponentiation", (a, b) -> Math.pow(a, b));
        calculator.addOperation("squareRoot", (a, b) -> Math.pow(a, 1 / b));

        System.out.println("Математические действия над числами: " + number1 + ", " + number2);
        System.out.println("Умножение");
        System.out.println(calculator.calculate("multiplication", number1, number2));

        System.out.println("Деление");
        System.out.println(calculator.calculate("division", number1, number2));

        System.out.println("Сумма");
        System.out.println(calculator.calculate("sum", number1, number2));

        System.out.println("Вычитание");
        System.out.println(calculator.calculate("difference", number1, number2));

        System.out.println("Возведение " + number1 + " в степень " + number2);
        System.out.println(calculator.calculate("exponentiation", number1, number2));

        System.out.println("Извлечение корня " + number2 + " степени");
        System.out.println(calculator.calculate("squareRoot", number1, number2));
    }
}
