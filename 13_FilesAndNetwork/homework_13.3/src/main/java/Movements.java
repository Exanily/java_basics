import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movements {
    private final String path;
    private final List<String[]> fragments = new ArrayList<>();
    private final HashMap<String, Double> hashOrganization = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        this.path = pathMovementsCsv;
        getTable();
    }

    public double getExpenseSum() {
        return getSum(7);
    }

    public double getIncomeSum() {
        return getSum(6);
    }

    public void parseSumExpensesOrganization() {
        for (String[] strings : fragments) {
            String[] fragment = strings[5].split("\\s\\s\\s");
            if (fragment[1].equals("")) {
                if (!hashOrganization.containsKey(fragment[2])) {
                    hashOrganization.put(fragment[2], Double.parseDouble(strings[7]));
                } else
                    hashOrganization.replace(fragment[2], hashOrganization.get(fragment[2]) + Double.parseDouble(strings[7]));
            } else {
                if (!hashOrganization.containsKey(fragment[1])) {
                    hashOrganization.put(fragment[1], Double.parseDouble(strings[7]));
                } else
                    hashOrganization.replace(fragment[1], hashOrganization.get(fragment[1]) + Double.parseDouble(strings[7]));
            }
        }
    }

    public void getSumExpensesOrganization() {
        parseSumExpensesOrganization();
        for (String s : hashOrganization.keySet()) {
            System.out.println(s.trim() + " : " + hashOrganization.get(s));
        }
    }

    private double getSum(int number) {
        double sum = 0;
        for (String[] strings : fragments) {
            String string = strings[number];
            sum += Double.parseDouble(string);
        }
        return sum;
    }

    private void getTable() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            int skip = 0;
            for (String line : lines) {
                if (skip == 0) {
                    skip++;
                    continue;
                }
                int pos1 = line.indexOf("\"");
                if (pos1 != -1) {
                    int pos2 = line.indexOf("\"", pos1 + 1);
                    line = replace(line, pos1 + 1, pos2);
                }
                String newLine = line.replace("\"", "");

                String[] fragment = newLine.split(",");
                if (fragment.length != 8) {
                        System.out.println("Wrong line: " + line);
                        continue;
                }
                fragments.add(fragment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String replace(String s, int pos1, int pos2) {
        char[] chars = s.toCharArray();
        for (int i = pos1; i < pos2; i++) {
            if (chars[i] == ',') {
                chars[i] = '.';
            }
        }
        return String.valueOf(chars);
    }
}
