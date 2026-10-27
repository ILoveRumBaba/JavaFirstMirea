package ru.mirea.task9.opt1;
import java.util.Arrays;

class Student implements Comparable<Student> {
    int idNumber;
    String name;
    public Student(int idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.idNumber, other.idNumber);
    }
    @Override
    public String toString() {
        return idNumber + " - " + name;
    }
}

public class Prac9Task1 {
    public static void insertionSort(Comparable<Student>[] list) {
        for (int i = 1; i < list.length; i++) {
            Comparable<Student> key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo((Student) key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Student[] iDNumber = {
                new Student(103, "Иван"),
                new Student(101, "Анна"),
                new Student(102, "Петр")
        };
        insertionSort(iDNumber);
        System.out.println(Arrays.toString(iDNumber));
    }
}
