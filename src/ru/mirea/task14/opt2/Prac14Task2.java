package ru.mirea.task14.opt2;
import java.util.regex.Pattern;

public class Prac14Task2 {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";
        System.out.println(Pattern.matches(regex, "abcdefghijklmnopqrstuv18340")); // true
        System.out.println(Pattern.matches(regex, "abcdefghijklmnoasdfasdpqrstuv18340")); // false
    }
}
