import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

public class EmailList {
    TreeSet<String> treeSet = new TreeSet<>();

    public void add(String email) {
        if(checkRegex(email)){
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
        String regex = "[\\w.-]+@[A-z]+\\.[A-z]+";
        return text.matches(regex);
    }
}
