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
        for (String s : list) {
            if (number.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        int search = Collections.binarySearch(sortedList, number);
        return search >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}
