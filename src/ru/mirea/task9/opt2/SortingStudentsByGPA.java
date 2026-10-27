package ru.mirea.task9.opt2;
import java.util.Arrays;
import java.util.Comparator;

class StudentGPA {
    String name;
    double gpa;
    public StudentGPA(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}

public class SortingStudentsByGPA implements Comparator<StudentGPA> {
    @Override
    public int compare(StudentGPA s1, StudentGPA s2) {
        return Double.compare(s2.gpa, s1.gpa); // по убыванию
    }
    public void quickSort(StudentGPA[] arr, int low, int high) {
        if (low >= high) return;
        StudentGPA pivot = arr[(low + high) / 2];
        int i = low, j = high;
        while (i <= j) {
            while (compare(arr[i], pivot) < 0) i++;
            while (compare(arr[j], pivot) > 0) j--;
            if (i <= j) {
                StudentGPA temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }
    public static void main(String[] args) {
        StudentGPA[] students = {
                new StudentGPA("Иван", 4.1),
                new StudentGPA("Анна", 4.9),
                new StudentGPA("Петр", 3.7)
        };
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.quickSort(students, 0, students.length - 1);
        System.out.println(Arrays.toString(students));
    }
}
