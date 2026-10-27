package ru.mirea.task13.opt6;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prac13Task6 {
    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return sb;
        List<String> list = new ArrayList<>(Arrays.asList(words));
        sb.append(list.remove(0));
        boolean found = true;
        while (!list.isEmpty() && found) {
            found = false;
            char last = Character.toLowerCase(sb.charAt(sb.length() - 1));
            for (int i = 0; i < list.size(); i++) {
                char first = Character.toLowerCase(list.get(i).charAt(0));
                if (last == first) {
                    sb.append(" ").append(list.remove(i));
                    found = true;
                    break;
                }
            }
        }
        return sb;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String fileName = sc.nextLine();
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        String[] words = content.trim().split("\\s+");
        System.out.println(getLine(words));
    }
}
