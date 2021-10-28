import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        return staff.stream().filter(employee -> {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(employee.getWorkStart());
            return calendar.get(Calendar.YEAR) == year;
        }).min(Comparator.comparing(Employee::getWorkStart)).orElseThrow();
    }
}