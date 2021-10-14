package company;

public class TopManager implements Employee {
    private static final double INTEREST = 1.5;
    private static final int INCOME = 10_000_000;
    private static final int SALARY = 50000;
    private final Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > INCOME) {
            return SALARY + (int) (INTEREST * SALARY);
        }
        return SALARY;
    }

    @Override
    public int getEarnedMoney() {
        return 0;
    }
}
