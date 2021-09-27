import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static EmailList emailList = new EmailList();

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
        String regexADD = "ADD (.)+";
        String regexLIST = "LIST";
        if (text.matches(regexADD)) {
            String email = text.substring(text.indexOf(' ') + 1);
            if (checkRegex(email)) {
                emailList.add(email);
            } else System.out.println(WRONG_EMAIL_ANSWER);
        } else if (text.matches(regexLIST)) {
            emailList.list();
        } else
            System.out.println("Неверная команда");
    }

    public static boolean checkRegex(String text) {
        String regex = "[\\w.-]+@[A-z]+\\.[A-z]+";
        return text.matches(regex);
    }

}
