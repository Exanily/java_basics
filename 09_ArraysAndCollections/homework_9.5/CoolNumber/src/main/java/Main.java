import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Генерация номеров.");
        CoolNumbers.generateCoolNumbers();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            numbers(input);
        }
    }

    public static void numbers(String number) {
        CoolNumbers.bruteForceSearchInList(CoolNumbers.list, number);
        CoolNumbers.binarySearchInList(CoolNumbers.list, number);
        HashSet<String> hashSet = new HashSet<>(CoolNumbers.list);
        CoolNumbers.searchInHashSet(hashSet, number);
        TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.list);
        CoolNumbers.searchInTreeSet(treeSet, number);
    }
}
