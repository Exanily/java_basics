import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(splitTextIntoWords(text));
    }

    public static String splitTextIntoWords(String text) {
        String regex = "[0-9,.;]";
        String regex2 = "[- ]+";
        String regex3 = "[ ]";
        return text.replaceAll(regex, "").replaceAll(regex2, " " ).replaceAll(regex3, "\n");
    }
}