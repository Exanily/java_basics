import java.util.Scanner;

public class Main {

    static TodoList todoList = new TodoList();

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

    public static void commands(String input) {
        String regex = "(ADD)?(DELETE)?(EDIT)?(LIST)? [\\w\\s]+";
        String regex2 = "(ADD)?(DELETE)?(EDIT)?";
        String command;

        if (!input.trim().matches(regex)) {
            command = input.trim();
        } else command = input.trim().substring(0, input.indexOf(' '));
        if (command.equals("ADD") || command.equals("LIST") || command.equals("DELETE") || command.equals("EDIT")) {
            if (input.equals("LIST")) {
                list();
            } else if (input.trim().matches(regex2)) {
                System.out.println("Ошибка");
            } else {
                String text = input.substring(input.indexOf(' '));
                String textTrim = text.trim();
                switch (command) {
                    case "ADD": {
                        add(textTrim);
                        break;
                    }
                    case "DELETE": {
                        delete(textTrim);
                        break;
                    }
                    case "EDIT": {
                        edit(textTrim);
                        break;
                    }
                }
            }
        } else System.out.println("Ошибка");
    }

    public static void add(String input) {
        String index = input.substring(0, input.indexOf(' '));
        String regex = "[0-9]+";
        String text;
        if (index.matches(regex)) {
            text = input.substring(input.indexOf(' ') + 1);
            todoList.add(Integer.parseInt(index), text);
        } else {
            todoList.add(input);
        }
    }

    public static void list() {
        for (int i = 0; i < todoList.getTodos().size(); i++) {
            System.out.println(i + " - " + todoList.getTodos().get(i));
        }
    }

    public static void delete(String index) {
        String regex = "[0-9]";
        if (index.matches(regex)) {
            todoList.delete(Integer.parseInt(index));
        } else System.out.println("Неверный индекс");
    }

    public static void edit(String text) {
        String index = text.substring(0, text.indexOf(' '));
        String regex = "[0-9]+";
        String text2;
        if (index.matches(regex)) {
            text2 = text.substring(text.indexOf(' ') + 1);
            todoList.edit(text2, Integer.parseInt(index));
        }
    }

}