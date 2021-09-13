public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());
        System.out.println();
        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        System.out.println(1105 + " - " + (char) 1105);
        System.out.println(1025 + " - " + (char) 1025);
        for (int i = 1040; i <= 1103; i++) {
            System.out.println(i + " - " + (char) i);

        }

        // 1040 - 1103 , 1105 - ё , 1025 - Ё
    }
}
