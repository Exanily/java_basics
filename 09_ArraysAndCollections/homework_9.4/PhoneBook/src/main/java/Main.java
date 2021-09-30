import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final PhoneBook phoneBook = new PhoneBook();
    public static final Pattern LIST = Pattern.compile("LIST");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            commands(input);
        }
    }

    public static void commands(String text) {
        Scanner scanner = new Scanner(System.in);
        boolean checkList = LIST.matcher(text).matches();
        boolean checkName = PhoneBook.PATTERN_NAME.matcher(text).matches();
        boolean checkPhone = PhoneBook.PATTERN_PHONE.matcher(text).matches();
        if (checkList) {
            phoneBook.printAllContacts();
        } else if (checkName) {
            if (!phoneBook.hashMap.containsKey(text)) {
                System.out.println("Такого имени в телефонной книге нет.\n" +
                        "Введите номер телефона для абонента “" + text + "”:");
            } else {
                System.out.println("Такое имя в телефонной книге есть.\n" +
                        "Введите номер телефона для абонента “" + text + "”:");
            }
            String phone = scanner.nextLine();
            phoneBook.addContact(phone, text);
        } else if (checkPhone) {
            if (!phoneBook.hashMap.containsValue(text)) {
                System.out.println("Такого номера нет в телефонной книге.\n" +
                        "Введите имя абонента для номера “" + text + "”:");
            } else {
                System.out.println("Такой номер есть в телефонной книге.\n" +
                        "Введите имя абонента для номера “" + text + "”:");
            }
            String name = scanner.nextLine();
            phoneBook.addContact(text, name);
        } else System.out.println(PhoneBook.ERROR);
    }
}
