package ru.mirea.task2.opt9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        final int cardsPerPlayer = 5;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        int n = sc.nextInt();

        String[] suits = {"Пик", "Треф", "Бубен", "Черв"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};

        int totalCards = suits.length * ranks.length; // 52 карты

        if (n <= 0) {
            System.out.println("Количество игроков должно быть больше 0.");
            return;
        }

        if (n * cardsPerPlayer > totalCards) {
            System.out.println("Слишком много игроков! В колоде всего 52 карты.");
            return;
        }

        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " " + suit);
            }
        }

        Collections.shuffle(deck);

        int cardIndex = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("Игрок " + i + ":");
            for (int j = 0; j < cardsPerPlayer; j++) {
                System.out.println(deck.get(cardIndex++));
            }
            System.out.println(); // Разделительная пустая строка
        }
    }
}
