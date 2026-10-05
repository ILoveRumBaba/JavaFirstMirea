package ru.mirea.task7.opt5_6;

interface StringProcessor {
    int countCharacters(String s);
    String getOddPositionChars(String s);
    String reverseString(String s);
}
class ProcessStrings implements StringProcessor {
    @Override
    public int countCharacters(String s) {
        if (s == null) return 0;
        return s.length();
    }
    @Override
    public String getOddPositionChars(String s) {
        if (s == null) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
    @Override
    public String reverseString(String s) {
        if (s == null) return "";
        return new StringBuilder(s).reverse().toString();
    }
}

class MainString {
    public static void main(String[] args) {
        StringProcessor processor = new ProcessStrings();
        String test = "ABCDEFG";

        System.out.println("Исходная строка: " + test);
        System.out.println("1) Количество символов: " + processor.countCharacters(test));
        System.out.println("2) Символы на нечетных позициях (1, 3, 5, 7): " + processor.getOddPositionChars(test));
        System.out.println("3) Инвертированная строка: " + processor.reverseString(test));
    }
}
