package ru.skillbox;

public class ArithmeticCalculator {
    private static int a;
    private static int b;

    public ArithmeticCalculator(int a, int b) {
        ArithmeticCalculator.a = a;
        ArithmeticCalculator.b = b;
    }

    public int calculate(Operation operation) {
        if (operation == Operation.ADD) {
            return a + b;
        }
        if (operation == Operation.SUBTRACT) {
            return a - b;
        }
        if (operation == Operation.MULTIPLY) {
            return a * b;
        }
        return 0;
    }
}
