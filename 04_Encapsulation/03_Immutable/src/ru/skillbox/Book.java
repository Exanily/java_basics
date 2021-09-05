package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int totalPages;
    private final int numberISBN;

    public Book(String name, String author, int totalPages, int numberISBN) {
        this.name = name;
        this.author = author;
        this.totalPages = totalPages;
        this.numberISBN = numberISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getNumberISBN() {
        return numberISBN;
    }

    public void print() {
        System.out.println("Название : " + getName());
        System.out.println("Автор : " + getAuthor());
        System.out.println("Количество страниц : " + getTotalPages());
        System.out.println("Номер ISBN : " + getNumberISBN());
        System.out.println();
    }
}
