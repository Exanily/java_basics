package company;

public class Manager implements Employee {
    private static final int MAX_AMOUNT_OF_MONEY_EARNED = 140_000;
    private static final int MIN_AMOUNT_OF_MONEY_EARNED = 115_000;

    private static final double INTEREST = 0.05;
    private int salary = 40000;

    public Manager(int salary) {
        this.salary = salary;
    }

    public Manager() {
        new Manager(salary);
    }

    public int getEarnedMoney() {
        return (int) (Math.random() * (MAX_AMOUNT_OF_MONEY_EARNED - MIN_AMOUNT_OF_MONEY_EARNED + 1) + MIN_AMOUNT_OF_MONEY_EARNED);
    }

    @Override
    public int getMonthSalary() {
        return salary + (int) (INTEREST * getEarnedMoney());
    }
}
