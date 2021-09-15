import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1995 , 5, 23);
        System.out.println(getPeriodFromBirthday(date));
    }

    private static String getPeriodFromBirthday(LocalDate birthday) {
        LocalDate date = LocalDate.now();
        LocalDate dat = date.minusYears(birthday.getYear()).minusMonths(birthday.getMonthValue()).minusDays(birthday.getDayOfMonth());
        return dat.getYear() + " years , " + dat.getMonthValue() + " months , " + dat.getDayOfMonth() + " days" ;
    }

}
