public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        String charStr = "заработал";
        String charStr2 = "рублей";
        String charStr3 = "-";
        String charStr4 = "рубля";
        int start = text.indexOf(charStr) + charStr.length() + 1;
        int end = text.indexOf(charStr2, start) - 1;
        String text2 = text.substring(start, end);
        int money = Integer.parseInt(text2);
        start = text.indexOf(charStr3) + charStr3.length() + 1;
        end = text.indexOf(charStr4, start) - 1;
        text2 = text.substring(start, end);
        money += Integer.parseInt(text2);
        start = text.lastIndexOf(charStr3) + charStr3.length() + 1;
        end = text.indexOf(charStr2, start) - 1;
        text2 = text.substring(start, end);
        money += Integer.parseInt(text2);
        System.out.println(money);
    }
}