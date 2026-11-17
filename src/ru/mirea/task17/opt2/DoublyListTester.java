package ru.mirea.task17.opt2;
import java.io.*;
import java.util.Scanner;

class DoublyStudentNode {
    String name;
    int age;
    String group;
    DoublyStudentNode prev;
    DoublyStudentNode next;

    public DoublyStudentNode() {}

    public DoublyStudentNode(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
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

class DoublyLinkedList {
    private DoublyStudentNode begin;
    private DoublyStudentNode end;

    // a. Создание пустого списка
    public void createEmpty() {
        begin = null;
        end = null;
    }

    // f. Проверка на пустоту
    public boolean isEmpty() {
        return begin == null;
    }

    // b. Добавление элемента в конец списка
    public void add(DoublyStudentNode newNode) {
        newNode.next = null;
        if (isEmpty()) {
            newNode.prev = null;
            begin = newNode;
            end = newNode;
        } else {
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        }
    }

    public boolean remove(String name) {
        if (isEmpty()) {
            return false;
        }
        DoublyStudentNode current = begin;
        while (current != null && !current.name.equalsIgnoreCase(name)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            begin = current.next; // Удаляемый элемент был первым
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            end = current.prev; // Удаляемый элемент был последним
        }
        return true;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        DoublyStudentNode current = begin;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public void clear() {
        begin = null;
        end = null;
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            DoublyStudentNode current = begin;
            while (current != null) {
                writer.println(current.name + ";" + current.age + ";" + current.group);
                current = current.next;
            }
            System.out.println("Список сохранен в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    add(new DoublyStudentNode(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
            System.out.println("Список загружен из файла " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}

public class DoublyListTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        list.createEmpty();

        while (true) {
            System.out.println("\n=== МЕНЮ (Двусвязный список) ===");
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
                    DoublyStudentNode node = new DoublyStudentNode();
                    node.readFromConsole(scanner);
                    list.add(node);
                    System.out.println("Элемент добавлен.");
                    break;
                case "3":
                    System.out.print("Введите имя для удаления: ");
                    if (list.remove(scanner.nextLine())) {
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
                    list.saveToFile("students_doubly.txt");
                    break;
                case "8":
                    list.loadFromFile("students_doubly.txt");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }
}