package ru.mirea.task3.opt1;
import java.util.Arrays;
import java.util.Random;

public class ArrayRandomSort {
    public static void main(String[] args) {
        int size = 15;

        System.out.println("=== Способ 1: Math.random() ===");
        double[] arr1 = new double[size];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Math.random() * 100;
        }

        System.out.print("Исходный массив: ");
        printArray(arr1);

        Arrays.sort(arr1);

        System.out.print("Отсортированный массив: ");
        printArray(arr1);

        System.out.println("\n=== Способ 2: класс Random ===");
        Random random = new Random();
        double[] arr2 = new double[size];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextDouble() * 100; // числа от 0.0 до 100.0
        }

        System.out.print("Исходный массив: ");
        printArray(arr2);
        Arrays.sort(arr2);
        System.out.print("Отсортированный массив: ");
        printArray(arr2);
    }

    private static void printArray(double[] array) {
        for (double num : array) {
            System.out.printf("%.2f  ", num);
        }
        System.out.println();
    }
}
