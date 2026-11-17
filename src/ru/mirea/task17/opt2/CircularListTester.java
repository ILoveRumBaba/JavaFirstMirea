package ru.mirea.task17.opt2;
import java.io.*;
import java.util.Scanner;

class CircularStudentNode {
    String name;
    int age;
    String group;
    CircularStudentNode next;

    public CircularStudentNode() {}

    public CircularStudentNode(String name, int age, String group) {
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

class CircularLinkedList {
    private CircularStudentNode head; // Указатель u на первый элемент

    public void createEmpty() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(CircularStudentNode newNode) {
        if (isEmpty()) {
            head = newNode;
            newNode.next = head; // Замыкаем на себя
        } else {
            CircularStudentNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Последний элемент ссылается на первый
        }
    }

    public boolean remove(String name) {
        if (isEmpty()) {
            return false;
        }
        CircularStudentNode current = head;
        CircularStudentNode prev = null;

        do {
            if (current.name.equalsIgnoreCase(name)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    if (head.next == head) {
                        head = null;
                    } else {
                        CircularStudentNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    }
                }
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        return false;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        CircularStudentNode current = head;
        do {
            current.display();
            current = current.next;
        } while (current != head);
    }

    public void clear() {
        head = null;
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            if (!isEmpty()) {
                CircularStudentNode current = head;
                do {
                    writer.println(current.name + ";" + current.age + ";" + current.group);
                    current = current.next;
                } while (current != head);
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
                    add(new CircularStudentNode(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
            System.out.println("Список загружен из файла " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}

public class CircularListTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        list.createEmpty();

        while (true) {
            System.out.println("\n=== МЕНЮ (Кольцевой список) ===");
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
                    CircularStudentNode node = new CircularStudentNode();
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
                    list.saveToFile("students_circular.txt");
                    break;
                case "8":
                    list.loadFromFile("students_circular.txt");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }
}
