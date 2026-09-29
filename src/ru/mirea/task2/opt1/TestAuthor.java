package ru.mirea.task2.opt1;

public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Иван Иванов", "ivan@example.com", 'm');

        System.out.println("Создан автор: " + author);

        System.out.println("Имя: " + author.getName());
        System.out.println("Почта: " + author.getEmail());
        System.out.println("Пол: " + author.getGender());

        author.setEmail("new_ivan@example.com");
        System.out.println("Обновленная инфо: " + author);
    }
}
