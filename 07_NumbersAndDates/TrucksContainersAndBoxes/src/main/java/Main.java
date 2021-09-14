import java.util.Scanner;

public class Main {

    private static final int MAX_BOX = 27;
    private static final int MAX_CONTAINER = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int box = (int) Math.ceil(Double.parseDouble(boxes));
        int container = (int) Math.ceil((double) box / MAX_BOX);
        int truck = (int) Math.ceil((double) container / MAX_CONTAINER);

        int container_i = 1;
        int box_i = 1;
        for (int i = 1; i <= truck; i++) {
            System.out.println("Грузовик: " + i);
            for (int j = container_i; j <= container; j++) {
                System.out.println("\tКонтейнер: " + j);
                for (int f = box_i; f <= box; f++) {
                    System.out.println("\t\tЯщик: " + f);
                    if (f % MAX_BOX == 0) {
                        box_i = ++f;
                        break;
                    }
                }
                if (j % MAX_CONTAINER == 0) {
                    container_i = ++j;
                    break;
                }
            }
        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + truck + " шт.");
        System.out.println("контейнеров - " + container + " шт.");
        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
