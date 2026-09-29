package ru.mirea.task2.opt10;
import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите слова через пробел:");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Количество введенных слов: 0");
        } else {
            String[] words = input.split("\\s+");
            System.out.println("Количество введенных слов: " + words.length);
        }
    }
}
