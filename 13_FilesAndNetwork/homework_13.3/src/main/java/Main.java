
public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\A3282\\OneDrive\\Рабочий стол\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementList.csv";
        Movements movements = new Movements(path);
        getExpenseSum(movements);
        getIncomeSum(movements);
        getSumExpensesOrganization(movements);
        System.out.println();
        String path1 = "C:\\Users\\A3282\\OneDrive\\Рабочий стол\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementListFloat.csv";
        Movements movements1 = new Movements(path1);
        getExpenseSum(movements1);
        getIncomeSum(movements1);
        getSumExpensesOrganization(movements1);
        System.out.println();
        String path2 = "C:\\Users\\A3282\\OneDrive\\Рабочий стол\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementListInteger.csv";
        Movements movements2 = new Movements(path2);
        getExpenseSum(movements2);
        getIncomeSum(movements2);
        getSumExpensesOrganization(movements2);

    }

    private static void getExpenseSum(Movements movements) {
        System.out.println("Сумма расходов: " + movements.getExpenseSum());
    }

    private static void getIncomeSum(Movements movements) {
        System.out.println("Сумма доходов: " + movements.getIncomeSum());
    }

    private static void getSumExpensesOrganization(Movements movements) {
        System.out.println("Суммы расходов по организациям : ");
        movements.getSumExpensesOrganization();
    }
}
