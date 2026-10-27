package ru.mirea.task10.opt2;

import java.util.Arrays;
import java.util.Comparator;

public class Prac10Task2 {
    static class Student {
        String name;
        int course;
        double gpa;
        public Student(String name, int course, double gpa) {
            this.name = name;
            this.course = course;
            this.gpa = gpa;
        }
        @Override
        public String toString() {
            return name + " (курс: " + course + ", балл: " + gpa + ")";
        }
    }

    static Student[] iDNumber;
    public static void setArray() {
        iDNumber = new Student[]{
                new Student("Иван", 3, 4.2),
                new Student("Анна", 1, 4.9),
                new Student("Петр", 2, 3.8)
        };
    }

    public static void outArray() {
        for (Student s : iDNumber) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        setArray();
        Arrays.sort(iDNumber, (s1, s2) -> Double.compare(s2.gpa, s1.gpa));
        System.out.println("По убыванию GPA:");
        outArray();
        Arrays.sort(iDNumber, Comparator.comparingInt(s -> s.course));
        System.out.println("По курсу:");
        outArray();
    }
}
