import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static EmailList emailList = new EmailList();

    public static final Pattern PATTERN = Pattern.compile("[\\w.-]+@[A-z]+\\.[A-z]+");
    public static final Pattern PATTERN_ADD = Pattern.compile("ADD (.)+");
    public static final Pattern PATTERN_LIST = Pattern.compile("LIST");

    private static Matcher matcher;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            commands(input);
        }
    }

    public static void commands(String text) {
        matcher = PATTERN_ADD.matcher(text);
        if (matcher.matches()) {
            String email = text.substring(text.indexOf(' ') + 1);
            if (checkRegex(email)) {
                emailList.add(email);
            } else System.out.println(WRONG_EMAIL_ANSWER);
        } else if (PATTERN_LIST.matcher(text).matches()) {
            emailList.list();
        } else
            System.out.println("Неверная команда");
    }

    public static boolean checkRegex(String text) {
        matcher = PATTERN.matcher(text);
        return matcher.matches();
    }
}
