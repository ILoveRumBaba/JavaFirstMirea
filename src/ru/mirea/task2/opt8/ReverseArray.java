package ru.mirea.task2.opt8;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        String[] arr = {"first", "second", "third", "fourth", "fifth"};

        System.out.println("До переворота:    " + Arrays.toString(arr));

        // Разворот массива на месте
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.println("После переворота: " + Arrays.toString(arr));
    }
}