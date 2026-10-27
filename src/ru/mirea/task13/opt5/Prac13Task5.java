package ru.mirea.task13.opt5;

public class Prac13Task5 {
    public static String formatPhone(String phone) {
        String last10 = phone.substring(phone.length() - 10);
        String code;
        if (phone.startsWith("+")) {
            code = phone.substring(1, phone.length() - 10);
        } else {
            code = "7";
        }
        return "+" + code + last10.substring(0, 3) + "-" + last10.substring(3, 6) + "-" + last10.substring(6);
    }
    public static void main(String[] args) {
        System.out.println(formatPhone("+79175655655"));
        System.out.println(formatPhone("+104289652211"));
        System.out.println(formatPhone("89175655655"));
    }
}
