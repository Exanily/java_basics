import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {


    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String text = "";

        for (int i = 0; today.compareTo(birthday) >= 0; i++) {
            text += i + " - " + formatter.format(birthday) + " - " + birthday.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US) + System.lineSeparator();
            birthday = birthday.plusYears(1);
        }
        return text;
    }
}
