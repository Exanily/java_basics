package ru.skillbox;

public class ArithmeticCalculator {
    private final int a;
    private final int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calculate(Operation operation) {
        switch (operation) {
            case ADD:
                System.out.println("Сложение : " + (a + b));
                break;
            case SUBTRACT:
                System.out.println("Вычитание  : " + (a - b));
                break;
            case MULTIPLY:
                System.out.println("Умножение : " + (a * b));
                break;
        }
    }
}
