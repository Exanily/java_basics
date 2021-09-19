import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            System.out.println(fullName(input));
        }
    }

    public static String fullName(String input) {
        char ch;
        int space = 0;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch == ' ') {
                space++;
            }
        }
        if (space != 2 || input.charAt(0) == ' ' || input.charAt(0) == '-') {
            return "Введенная строка не является ФИО";
        }
        String surname = input.substring(0, input.indexOf(' '));
        String name = input.substring(input.indexOf(' ') + 1, input.lastIndexOf(' '));
        String patronymic = input.substring(input.lastIndexOf(' ') + 1);
        if (isInteger(surname) || isInteger(name) || isInteger(patronymic)) {
            return "Введенная строка не является ФИО";
        }
        return String.format("Фамилия: %s%nИмя: %s%nОтчество: %s", surname, name, patronymic);
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}