import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            System.out.println(phoneNumber(input));
        }
    }

    public static StringBuilder phoneNumber(String input) {
        String regex = "[^0-9]";
        StringBuilder number;
        number = new StringBuilder(input.replaceAll(regex, ""));

        if (number.length() == 11) {
            if (number.charAt(0) == '8' || number.charAt(0) == '7') {
                if (number.charAt(0) == '8') {
                    return number.replace(0, 1, "7");
                }
                return number;
            } else return new StringBuilder("Неверный формат номера");
        } else if (number.length() == 10) {
            return number.reverse().append("7").reverse();
        } else return new StringBuilder("Неверный формат номера");
    }
}