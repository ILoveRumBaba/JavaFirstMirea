package ru.mirea.task2.opt4;

import java.util.Scanner;

public class ShopTester {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Меню магазина ---");
            System.out.println("1. Добавить компьютер");
            System.out.println("2. Удалить компьютер");
            System.out.println("3. Найти компьютер");
            System.out.println("4. Показать все компьютеры");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название/модель: ");
                    String name = sc.nextLine();
                    System.out.print("Введите цену: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    shop.addComputer(new Computer(name, price));
                    break;
                case 2:
                    System.out.print("Введите название для удаления: ");
                    String toRemove = sc.nextLine();
                    shop.removeComputer(toRemove);
                    break;
                case 3:
                    System.out.print("Введите название для поиска: ");
                    String toFind = sc.nextLine();
                    Computer found = shop.findComputer(toFind);
                    if (found != null) {
                        System.out.println("Найден: " + found);
                    } else {
                        System.out.println("Компьютер \"" + toFind + "\" не найден.");
                    }
                    break;
                case 4:
                    shop.printComputers();
                    break;
                case 5:
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Неверный пункт, попробуйте снова.");
            }
        }
    }
}