package ru.mirea.task2.opt7;

public class BookTest {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf(5);

        shelf.addBook(new Book("Лев Толстой", "Война и мир", 1869));
        shelf.addBook(new Book("Федор Достоевский", "Преступление и наказание", 1866));
        shelf.addBook(new Book("Михаил Булгаков", "Мастер и Маргарита", 1967));
        shelf.addBook(new Book("Александр Пушкин", "Евгений Онегин", 1833));

        System.out.println("Количество книг на полке: " + shelf.getCount());
        System.out.println("Самая ранняя книга: " + shelf.getEarliestBook());
        System.out.println("Самая поздняя книга: " + shelf.getLatestBook());

        System.out.println("\nКниги до сортировки:");
        shelf.printBooks();

        shelf.sortByYear();

        System.out.println("\nКниги после сортировки по возрастанию года:");
        shelf.printBooks();
    }
}
