import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine().trim();
                print(line);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    private static void print(String line) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        final double const1 = 1024;
        long byte1 = FileUtils.calculateFolderSize(line);
        double KByte = byte1 / const1;
        double result;
        String dimension;
        if (KByte >= 1) {
            double MByte = KByte / const1;
            if (MByte >= 1) {
                double GByte = MByte / const1;
                if (GByte >= 1) {
                    result = GByte;
                    dimension = "ГБайт";
                } else {
                    result = MByte;
                    dimension = "МБайт";
                }
            } else {
                result = KByte;
                dimension = "KБайт";
            }
        } else {
            result = byte1;
            dimension = "байт";
        }
        System.out.println(formatter.format(result) + " " + dimension);
    }
}
