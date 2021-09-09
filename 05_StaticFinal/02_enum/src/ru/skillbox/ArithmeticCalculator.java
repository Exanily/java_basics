package ru.skillbox;

public class ArithmeticCalculator {
    private final int a;
    private final int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void getCalculate(){
        System.out.println("Сложение : " + calculate(Operation.ADD));
        System.out.println("Вычитание  : " + calculate(Operation.SUBTRACT));
        System.out.println("Умножение : " + calculate(Operation.MULTIPLY));
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
