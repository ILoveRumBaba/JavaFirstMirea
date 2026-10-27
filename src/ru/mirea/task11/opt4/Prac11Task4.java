package ru.mirea.task11.opt4;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Prac11Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Год Месяц(1-12) Число: ");
        int year = sc.nextInt();
        int month = sc.nextInt() - 1;
        int day = sc.nextInt();
        System.out.print("Введите Часы Минуты: ");
        int hours = sc.nextInt();
        int minutes = sc.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hours, minutes, 0);
        Date date = calendar.getTime();
        System.out.println("Date: " + date);
        System.out.println("Calendar: " + calendar.getTime());
    }
}
