package ru.mirea.task11.opt2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Prac11Task2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите дату (дд.ММ.гггг): ");
        String input = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date userDate = sdf.parse(input);
        Date now = new Date();
        if (userDate.before(now)) {
            System.out.println("Введенная дата меньше (раньше) текущей.");
        } else if (userDate.after(now)) {
            System.out.println("Введенная дата больше (позже) текущей.");
        } else {
            System.out.println("Даты равны.");
        }
    }
}
