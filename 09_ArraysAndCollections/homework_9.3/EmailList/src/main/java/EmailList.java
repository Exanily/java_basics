import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class EmailList {
    TreeSet<String> treeSet = new TreeSet<>();
    public static final Pattern PATTERN = Pattern.compile("[\\w.-]+@[A-z]+\\.[A-z]+");

    public void add(String email) {
        if (checkRegex(email)) {
            treeSet.add(emailLower(email));
        }

    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(treeSet);
    }

    public void list() {
        for (String s : treeSet) {
            System.out.println(s);
        }
    }

    public static String emailLower(String text) {
        return text.toLowerCase(Locale.ROOT);
    }

    public static boolean checkRegex(String text) {
        return text.matches(PATTERN.pattern());
    }
}
