package ru.mirea.task1.opt6;

public class HarmonicSeries {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Число %2d: 1/%-2d = %.4f%n", i, i, 1.0 / i);
        }
    }
}