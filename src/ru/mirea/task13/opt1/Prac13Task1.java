package ru.mirea.task13.opt1;

public class Prac13Task1 {
    public static void process(String str) {
        System.out.println("2. Последний символ: " + str.charAt(str.length() - 1));
        System.out.println("3. Заканчивается на '!!!': " + str.endsWith("!!!"));
        System.out.println("4. Начинается на 'I like': " + str.startsWith("I like"));
        System.out.println("5. Содержит 'Java': " + str.contains("Java"));
        System.out.println("6. Позиция 'Java': " + str.indexOf("Java"));
        System.out.println("7. Замена 'a' на 'o': " + str.replace('a', 'o'));
        System.out.println("8. Верхний регистр: " + str.toUpperCase());
        System.out.println("9. Нижний регистр: " + str.toLowerCase());
        int idx = str.indexOf("Java");
        System.out.println("10. Вырезано 'Java': " + str.substring(idx, idx + 4));
    }
    public static void main(String[] args) {
        process("I like Java!!!");
    }
}
