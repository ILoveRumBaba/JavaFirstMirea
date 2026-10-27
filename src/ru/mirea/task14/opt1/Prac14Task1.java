package ru.mirea.task14.opt1;

import java.util.Arrays;
import java.util.Scanner;

public class Prac14Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = sc.nextLine();
        String[] parts = input.split("[\\s,.;!?]+");
        System.out.println(Arrays.toString(parts));
    }
}
