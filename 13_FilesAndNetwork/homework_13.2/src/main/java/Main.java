import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //for (; ; ) {
            try {
                System.out.println("Введите путь к папке которую нужно скопировать : ");
                Scanner scanner = new Scanner(System.in);
                String sourceDirectory = scanner.nextLine().trim();
                System.out.println("Введите путь к папке которую нужно скопировать : ");
                scanner = new Scanner(System.in);
                String destinationDirectory = scanner.nextLine().trim();
                FileUtils.copyFolder(sourceDirectory, destinationDirectory);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        //}
    }
}