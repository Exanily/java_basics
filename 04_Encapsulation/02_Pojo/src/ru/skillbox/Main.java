package ru.skillbox;

public class Main {
    public static void main(String[] args) {
        Country germany = new Country("Германия"); // метод setNameCountry не использован, так как в этой строке уже задано название страны
        germany.setCapitalName("Берлин");
        germany.setPopulation(83020000);
        germany.setSquare(357386);
        germany.setSea(true);

        System.out.println("Название страны : " + germany.getNameCountry());
        System.out.println("Численность населения : " + germany.getPopulation());
        System.out.println("Площадь в квадратных километрах : " + germany.getSquare());
        System.out.println("Название столицы : " + germany.getCapitalName());
        System.out.println("Наличие выхода к морю : " + germany.getSea());
    }
}
