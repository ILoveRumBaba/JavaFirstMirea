package ru.mirea.task1.opt4;

import java.util.Scanner;
public class ShowArgs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sumDoWhile = 0;
        int i = 0;
        if (n > 0) {
            do {
                sumDoWhile += arr[i];
                i++;
            } while (i < n);
        }

        int sumWhile = 0;
        int min = arr[0];
        int max = arr[0];
        int j = 0;

        while (j < n) {
            sumWhile += arr[j];
            if (arr[j] < min) min = arr[j];
            if (arr[j] > max) max = arr[j];
            j++;
        }

        System.out.println("Сумма (do-while): " + sumDoWhile);
        System.out.println("Сумма (while): " + sumWhile);
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
    }
}
