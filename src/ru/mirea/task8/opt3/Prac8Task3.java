package ru.mirea.task8.opt3;
import java.util.Scanner;

public class Prac8Task3 {
    public static void rec(int a, int b) {
        System.out.print(a + " ");
        if (a == b) return;
        if (a < b) {
            rec(a + 1, b);
        } else {
            rec(a - 1, b);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число A: ");
        int a = sc.nextInt();
        System.out.print("Введите число B: ");
        int b = sc.nextInt();
        rec(a, b);
        System.out.println();
    }
}
