import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
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
        String[] name = new String[3];
        String regex = "[А-я-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            name[i] = input.substring(start, end);
            i++;
        }
        for (int j = 0; j < 3; j++) {
            if (name[0] == null) {
                return "Введенная строка не является ФИО";
            }
        }

        return String.format("Фамилия: %s%nИмя: %s%nОтчество: %s", name[0], name[1], name[2]);
    }
}