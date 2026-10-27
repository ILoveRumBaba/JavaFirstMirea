package ru.mirea.task11.opt5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Prac11Task5 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int n = 50000;
        long t1 = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.add(i);
        System.out.println("ArrayList add:     " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.add(i);
        System.out.println("LinkedList add:    " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        arrayList.add(n / 2, 999);
        System.out.println("ArrayList insert:  " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        linkedList.add(n / 2, 999);
        System.out.println("LinkedList insert: " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        arrayList.contains(999);
        System.out.println("ArrayList search:  " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        linkedList.contains(999);
        System.out.println("LinkedList search: " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        arrayList.remove(n / 2);
        System.out.println("ArrayList remove:  " + (System.nanoTime() - t1) + " нс");
        t1 = System.nanoTime();
        linkedList.remove(n / 2);
        System.out.println("LinkedList remove: " + (System.nanoTime() - t1) + " нс");
    }
}