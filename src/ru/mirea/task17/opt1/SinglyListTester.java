package ru.mirea.task17.opt1;

import java.io.*;
import java.util.Scanner;
class StudentNode {
    String name;
    int age;
    String group;
    StudentNode next;

    public StudentNode() {
        this.next = null;
    }

    public StudentNode(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.next = null;
    }

    public void readFromConsole(Scanner scanner) {
        System.out.print("Введите имя студента: ");
        this.name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите группу: ");
        this.group = scanner.nextLine();
    }

    public void display() {
        System.out.printf("Студент: %-15s | Возраст: %-3d | Группа: %-10s%n", name, age, group);
    }
}

class SinglyLinkedList {
    private StudentNode head; // Указатель на начало списка (u)

    public void createEmpty() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(StudentNode newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(String name) {
        if (isEmpty()) {
            return false;
        }
        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            return true;
        }
        StudentNode current = head;
        while (current.next != null && !current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public void clear() {
        head = null;
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            StudentNode current = head;
            while (current != null) {
                writer.println(current.name + ";" + current.age + ";" + current.group);
                current = current.next;
            }
            System.out.println("Список успешно сохранен в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    add(new StudentNode(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
            System.out.println("Список успешно загружен из файла " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }
}

public class SinglyListTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        list.createEmpty();

        while (true) {
            System.out.println("\n=== МЕНЮ (Односвязный список) ===");
            System.out.println("1. Создать пустой список");
            System.out.println("2. Добавить студента");
            System.out.println("3. Удалить студента по имени");
            System.out.println("4. Показать всех студентов");
            System.out.println("5. Проверить список на пустоту");
            System.out.println("6. Очистить список");
            System.out.println("7. Сохранить в файл");
            System.out.println("8. Загрузить из файла");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    list.createEmpty();
                    System.out.println("Пустой список создан.");
                    break;
                case "2":
                    StudentNode node = new StudentNode();
                    node.readFromConsole(scanner);
                    list.add(node);
                    System.out.println("Элемент добавлен.");
                    break;
                case "3":
                    System.out.print("Введите имя для удаления: ");
                    String name = scanner.nextLine();
                    if (list.remove(name)) {
                        System.out.println("Студент удален.");
                    } else {
                        System.out.println("Студент не найден.");
                    }
                    break;
                case "4":
                    list.displayList();
                    break;
                case "5":
                    System.out.println(list.isEmpty() ? "Список пуст." : "В списке есть элементы.");
                    break;
                case "6":
                    list.clear();
                    System.out.println("Список очищен.");
                    break;
                case "7":
                    list.saveToFile("students_singly.txt");
                    break;
                case "8":
                    list.loadFromFile("students_singly.txt");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Неверный ввод. Повторите попытку.");
            }
        }
    }
}
