package ru.skillbox;

public class ArithmeticCalculator {
    private final int a;
    private final int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calculate(Operation operation) {
        if (operation == Operation.ADD) {
            System.out.println("Сложение : " + (a + b));
        }
        if (operation == Operation.SUBTRACT) {
            System.out.println("Вычитание  : " + (a - b));
        }
        if (operation == Operation.MULTIPLY) {
            System.out.println("Вычитание  : " + (a * b));
        }
    }
}
