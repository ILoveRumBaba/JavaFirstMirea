package ru.mirea.task1.opt7;

public class FactorialTest {

    public static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("0! = " + calculateFactorial(0));
        System.out.println("3! = " + calculateFactorial(3));
        System.out.println("5! = " + calculateFactorial(5));
        System.out.println("6! = " + calculateFactorial(6));
    }
}