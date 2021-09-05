package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Изучаем Java", "Кэти Сьерра, Берт Бейтс", 352, 895467843);
        book.print();

        Product product = new Product("Изучаем Java",4235365);
        product.setPrice(2500);
        product.print();
    }
}
