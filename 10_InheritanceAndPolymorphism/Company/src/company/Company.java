package company;

import java.util.*;

public class Company {
    private final List<Employee> employees = new ArrayList<>();
    private int income;
    private int earnedMoney;
    private int allMonthSalaries;

    public void hire(Employee employee) {
        employees.add(employee);
        earnedMoney += employee.getEarnedMoney();
        allMonthSalaries += employee.getMonthSalary();
        income = earnedMoney - allMonthSalaries;
    }

    public void hireAll(List<Employee> employees) {
        for (Employee i : employees) {
            hire(i);
        }
    }

    public void fire(Employee employee) {
        earnedMoney -= employee.getEarnedMoney();
        allMonthSalaries -= employee.getMonthSalary();
        income = earnedMoney - allMonthSalaries;
        employees.remove(employee);
    }

    public int getIncome() {
        return income;
    }

    public int getEarnedMoney() {
        return earnedMoney;
    }

    public int getAllMonthSalaries() {
        return allMonthSalaries;
    }

    public List<Employee> getEmployee() {
        return new ArrayList<>(employees);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        count = chekCount(count);
        employees.sort((o1, o2) -> Integer.compare(o2.getMonthSalary(), o1.getMonthSalary()));
        return new ArrayList<>(employees.subList(0, count));
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        count = chekCount(count);
        employees.sort(Comparator.comparingInt(Employee::getMonthSalary));
        return new ArrayList<>(employees.subList(0, count));
    }

    private int chekCount(int count) {
        if (count < 0) {
            System.out.println("Введено неверное значение");
            return 0;
        }
        if (count > employees.size()) {
            count = employees.size();
        }
        return count;
    }
}
