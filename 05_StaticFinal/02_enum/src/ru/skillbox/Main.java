package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(9,6);
        calculator.calculate(Operation.ADD);
        calculator.calculate(Operation.SUBTRACT);
        calculator.calculate(Operation.MULTIPLY);
    }
}
