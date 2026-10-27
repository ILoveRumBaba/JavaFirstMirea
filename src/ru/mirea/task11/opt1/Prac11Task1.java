package ru.mirea.task11.opt1;
import java.util.Date;

public class Prac11Task1 {
    public static void main(String[] args) {
        System.out.println("Фамилия разработчика: Иванов");
        Date startDate = new Date(1729900000000L);
        Date endDate = new Date();
        System.out.println("Дата получения задания: " + startDate);
        System.out.println("Дата сдачи задания: " + endDate);
    }
}