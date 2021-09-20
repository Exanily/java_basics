public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        String charStr = "5000";
        String charStr2 = "7563";
        String charStr3 = "30000";
        int start = text.indexOf(charStr);
        int end = text.indexOf(charStr) + 4;
        String text2 = text.substring(start, end);
        int money = Integer.parseInt(text2);
        start = text.indexOf(charStr2);
        end = text.indexOf(charStr2) + 4;
        text2 = text.substring(start, end);
        money += Integer.parseInt(text2);
        start = text.indexOf(charStr3);
        end = text.indexOf(charStr3) + 5;
        text2 = text.substring(start, end);
        money += Integer.parseInt(text2);
        System.out.println(money);
    }
}