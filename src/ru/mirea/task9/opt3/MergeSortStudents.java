package ru.mirea.task9.opt3;

class Student implements Comparable<Student> {
    private int idNumber;
    private String name;
    private double gpa;

    public Student(int idNumber, String name, double gpa) {
        this.idNumber = idNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.idNumber, other.idNumber);
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Имя: %-15s | Средний балл (GPA): %.2f", idNumber, name, gpa);
    }
}

public class MergeSortStudents {
    public static void mergeSort(Comparable[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[n - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(array, left, right, mid, n - mid);
    }

    @SuppressWarnings("unchecked")
    public static void merge(Comparable[] result, Comparable[] left, Comparable[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            result[k++] = left[i++];
        }
        while (j < rightSize) {
            result[k++] = right[j++];
        }
    }

    public static Student[] mergeTwoStudentLists(Student[] list1, Student[] list2) {
        mergeSort(list1, list1.length);
        mergeSort(list2, list2.length);
        Student[] mergedResult = new Student[list1.length + list2.length];
        merge(mergedResult, list1, list2, list1.length, list2.length);
        return mergedResult;
    }

    public static void main(String[] args) {
        Student[] group1 = {
                new Student(105, "Иванов И.И.", 4.5),
                new Student(101, "Петров П.П.", 3.9),
                new Student(108, "Сидоров С.С.", 4.8)
        };

        Student[] group2 = {
                new Student(103, "Смирнова А.В.", 4.9),
                new Student(102, "Кузнецов Д.А.", 4.1),
                new Student(107, "Морозова Е.И.", 4.4),
                new Student(104, "Волков К.Н.", 3.7)
        };

        System.out.println("Список 1 до сортировки:");
        for (Student s : group1) System.out.println(s);

        System.out.println("\nСписок 2 до сортировки:");
        for (Student s : group2) System.out.println(s);

        Student[] sortedCombinedList = mergeTwoStudentLists(group1, group2);

        System.out.println("\nОбъединенный отсортированный список студентов:");
        for (Student s : sortedCombinedList) {
            System.out.println(s);
        }
    }
}
