import java.util.*;

public class CoolNumbers {
    public static List<String> list = new ArrayList<>();
    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    public static List<String> generateCoolNumbers() {
        StringBuilder numberCar = new StringBuilder();
        for (String firstLetter : LETTERS) {
            for (int number = 0; number < 10; number++) {
                for (String secondLetter : LETTERS) {
                    for (String thirdLetter : LETTERS) {
                        for (int region = 1; region < 200; region++) {
                            numberCar.append(firstLetter);
                            numberCar.append(number).append(number).append(number);
                            numberCar.append(secondLetter);
                            numberCar.append(thirdLetter);
                            if (region < 10) {
                                numberCar.append("0").append(region);
                            } else {
                                numberCar.append(region);
                            }
                            list.add(String.valueOf(numberCar));
                            numberCar.delete(0, numberCar.length());
                        }
                    }
                }
            }
        }
        System.out.println("Генерация завершена.");
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        long end = 0;
        boolean b = false;
        long start = System.nanoTime();
        for (String s : list) {
            if (number.equals(s)) {
                end = System.nanoTime();
                b = true;
                break;
            }
            end = System.nanoTime();
        }
        System.out.println("Поиск перебором:");
        print(b, start, end);
        return b;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        long start = System.nanoTime();
        int search = Collections.binarySearch(sortedList, number);
        long end = System.nanoTime();
        boolean b = search >= 0;
        System.out.println("Бинарный поиск:");
        print(b, start, end);
        return b;

    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long start = System.nanoTime();
        boolean b = hashSet.contains(number);
        long end = System.nanoTime();
        System.out.println("Поиск в HashSet:");
        print(b, start, end);
        return b;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long start = System.nanoTime();
        boolean b = treeSet.contains(number);
        long end = System.nanoTime();
        System.out.println("Поиск в TreeSet:");
        print(b, start, end);
        return b;
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
