public class Main {

    public static void main(String[] args) {

        Basket sachaBasket = new Basket();
        sachaBasket.add("Молоко", 40, 3, 1);
        sachaBasket.add("Кола", 80, 2, 2);
        sachaBasket.add("Колбаса", 300, 4,1);
        sachaBasket.print("Корзина Саши:");
        System.out.println("Общая стоимость всех товаров: " + sachaBasket.getTotalPrice() + " руб");
        System.out.println("Общая масса всех товаров: " + sachaBasket.getTotalWeight() + " кг.");
        System.out.println();

        Basket dimaBasket = new Basket();
        dimaBasket.add("Сосиски", 200, 2, 1);
        dimaBasket.add("Вода", 30, 4, 2);
        dimaBasket.add("Мясо", 300, 3,1);
        dimaBasket.print("Корзина Димы:");
        System.out.println("Общая стоимость всех товаров: " + dimaBasket.getTotalPrice() + " руб");
        System.out.println("Общая масса всех товаров: " + dimaBasket.getTotalWeight() + " кг.");

        System.out.println();
        System.out.println("Количество корзин : " + Basket.getCount());
        System.out.println("Общая стоимости корзин : " + Basket.getTotalCost());
        System.out.println("Общее количество всех товаров в корзинах : " + Basket.getTotalAmountProduct() + " шт.");
        System.out.println("Средняя цена товара во всех корзинах : " + Basket.averageProductPrice() + " руб.");
        System.out.println("Средняя цена корзины : " + Basket.averagePriceBasket() + " руб.");

        /*

        System.out.println("======== Задание 2 ========");
        Arithmetic arithmetic = new Arithmetic(23, 45);
        System.out.println("Сумма чисел: " + arithmetic.sum());
        System.out.println("Произведение чисел: " + arithmetic.multiplication());
        System.out.println("Максимальное из двух чисел: " + arithmetic.max());
        System.out.println("Минимальное из двух чисел: " + arithmetic.min());
        System.out.println();


        System.out.println("======== Задание 3 ========");
        Printer printer = new Printer();
        printer.append("Ф.И.О", "Паспорт", 32);
        printer.append("Произведение Л. Н. Толстой. Война и мир", "Война и мир", 723);
        printer.append("Java", "Изучаем Java", 517);
        printer.print("Очередь:");
        System.out.println("Всего страниц напечатано: " + printer.getTotalPages());

         */
    }
}
