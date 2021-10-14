package company;

public class Operator implements Employee {
    private int salary = 30000;

    public Operator(int salary) {
        this.salary = salary;
    }

    public Operator() {
        new Operator(salary);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public int getEarnedMoney() {
        return 0;
    }
}
