package ru.mirea.task14.opt3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prac14Task3 {
    public static void main(String[] args) {
        String text = "Цены: 25.98 USD, 100 RUB, 44 ERR, 0.004 EU, 15.5 EU.";
        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d{1,2})?\\s+(USD|RUB|EU)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
