package ru.mirea.task3.opt4;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EvenArrayFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Введите размер массива (натуральное число): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Неверный ввод! Число должно быть целым и больше 0. Повторите попытку.");
        }

        int[] firstArray = new int[n];
        Random random = new Random();
        int evenCount = 0;

        for (int i = 0; i < n; i++) {
            firstArray[i] = random.nextInt(n + 1);
            if (firstArray[i] % 2 == 0) {
                evenCount++;
            }
        }

        System.out.println("Первый массив: " + Arrays.toString(firstArray));

        if (evenCount > 0) {
            int[] secondArray = new int[evenCount];
            int index = 0;

            for (int i = 0; i < n; i++) {
                if (firstArray[i] % 2 == 0) {
                    secondArray[index] = firstArray[i];
                    index++;
                }
            }

            System.out.println("Второй массив (только четные элементы): " + Arrays.toString(secondArray));
        } else {
            System.out.println("В первом массиве нет четных элементов.");
        }
    }
}