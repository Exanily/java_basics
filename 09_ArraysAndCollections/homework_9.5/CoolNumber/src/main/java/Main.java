import java.util.*;

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
        List<String> list = CoolNumbers.list;
        long start = System.nanoTime();
        boolean search = CoolNumbers.bruteForceSearchInList(list, number);
        long end = System.nanoTime();
        System.out.print("Поиск перебором:");
        print(search, start, end);

        Collections.sort(list);
        start = System.nanoTime();
        search = CoolNumbers.binarySearchInList(list, number);
        end = System.nanoTime();
        System.out.print("Бинарный поиск:");
        print(search, start, end);

        HashSet<String> hashSet = new HashSet<>(list);
        start = System.nanoTime();
        search = CoolNumbers.searchInHashSet(hashSet, number);
        end = System.nanoTime();
        System.out.print("Поиск в HashSet:");
        print(search, start, end);

        TreeSet<String> treeSet = new TreeSet<>(list);
        start = System.nanoTime();
        search = CoolNumbers.searchInTreeSet(treeSet, number);
        end = System.nanoTime();
        System.out.print("Поиск в TreeSet:");
        print(search, start, end);
    }

    public static void print(boolean b, long start, long end) {
        long nanoTime = end - start;
        String s;
        if (b) {
            s = "найден";
        } else {
            s = "не найден";
        }
        System.out.println(s + ", поиск занял " + nanoTime + "нс");
    }
}
