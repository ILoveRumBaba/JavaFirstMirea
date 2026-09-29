package ru.mirea.task2.opt7;

public class BookShelf {
    private Book[] books;
    private int count;

    public BookShelf(int capacity) {
        this.books = new Book[capacity];
        this.count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Полка заполнена!");
        }
    }

    public int getCount() {
        return count;
    }

    public Book getEarliestBook() {
        if (count == 0) return null;
        Book earliest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() < earliest.getYear()) {
                earliest = books[i];
            }
        }
        return earliest;
    }

    public Book getLatestBook() {
        if (count == 0) return null;
        Book latest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() > latest.getYear()) {
                latest = books[i];
            }
        }
        return latest;
    }

    public void sortByYear() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void printBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}