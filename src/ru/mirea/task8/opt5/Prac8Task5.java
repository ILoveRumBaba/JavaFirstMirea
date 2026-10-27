package ru.mirea.task8.opt5;
import java.util.Scanner;

public class Prac8Task5 {
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumDigits(n / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите натуральное число N: ");
        int n = sc.nextInt();
        System.out.println("Сумма цифр: " + sumDigits(n));
    }
}
