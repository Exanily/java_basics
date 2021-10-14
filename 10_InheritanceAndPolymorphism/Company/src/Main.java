import company.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Manager());
        }
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TopManager(company));
        }
        company.hireAll(list);
        getIncome(company);
        getTopSalary(company, 15);
        getLowestSalary(company, 30);
        int size = company.getEmployee().size() / 2 ;
        for (int i = 0; i < size; i++) {
            company.fire(company.getEmployee().get(i));
        }
        getIncome(company);
        getTopSalary(company, 15);
        getLowestSalary(company, 30);
    }

    public static void getLowestSalary(Company company, int count) {
        System.out.println("Список зарплат по возрастанию : ");
        for (Employee i : company.getLowestSalaryStaff(count)) {
            System.out.println("\t" + i.getMonthSalary());
        }
    }

    public static void getTopSalary(Company company, int count) {
        System.out.println("Список зарплат по убыванию : ");
        for (Employee i : company.getTopSalaryStaff(count)) {
            System.out.println("\t" + i.getMonthSalary());
        }
    }

    public static void getIncome(Company company) {
        System.out.println("Доход компании : " + company.getIncome());
    }
}
