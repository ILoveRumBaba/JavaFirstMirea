package ru.mirea.task1.opt3;
public class ArraySum {
    public static void main(String[] args) {
        int[] myArray = {5, 10, 15, 20, 25, 30};
        int totalSum = 0;
        System.out.println("Элементы массива:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + "\t");
            totalSum += myArray[i];
        }
        double avgValue = (double) totalSum / myArray.length;
        System.out.println("\n");
        System.out.println("Итоговая сумма всех элементов: " + totalSum);
        System.out.println("Среднее арифметическое значение: " + avgValue);
    }
}