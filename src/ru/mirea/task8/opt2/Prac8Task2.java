package ru.mirea.task8.opt2;

import java.util.Scanner;

public class Prac8Task2 {
    public static void rec(int n) {
        if (n == 0) return;
        rec(n - 1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        int n = sc.nextInt();
        rec(n);
        System.out.println();
    }
}
