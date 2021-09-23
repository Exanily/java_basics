import java.util.Scanner;
import java.util.regex.Pattern;

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
        String regexCompile = "([7])([0-9]{3,3})([0-9]{3,3})([0-9]{2,2})([0-9]{2,2})";
        StringBuilder number;
        number = new StringBuilder(input.replaceAll(regex, ""));

        if (number.length() == 11) {
            if (number.charAt(0) == '8' || number.charAt(0) == '7') {
                if (number.charAt(0) == '8') {
                    return new StringBuilder(Pattern.compile(regexCompile)
                            .matcher(number.replace(0, 1, "7"))
                            .replaceAll("+$1 ($2) $3 $4-$5"));
                }
                return new StringBuilder(Pattern.compile(regexCompile)
                        .matcher(number)
                        .replaceAll("+$1 ($2) $3 $4-$5"));
            } else return new StringBuilder("Неверный формат номера");
        } else if (number.length() == 10) {
            return new StringBuilder(Pattern.compile(regexCompile)
                    .matcher(number.reverse().append("7").reverse())
                    .replaceAll("+$1 ($2) $3 $4-$5"));
        } else return new StringBuilder("Неверный формат номера");
    }
}