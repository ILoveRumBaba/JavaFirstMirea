package ru.mirea.task4.opt3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
enum Category {
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    BOOKS("Книги");
    private final String title;
    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Product {
    String name;
    double price;
    Category category;
    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    @Override
    public String toString() {
        return name + " — " + price + " руб.";
    }
}
public class OnlineStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctLogin = "user";
        String correctPassword = "123";

        System.out.println("=== ВХОД В ИНТЕРНЕТ-МАГАЗИН ===");
        while (true) {
            System.out.print("Введите логин: ");
            String login = scanner.nextLine();

            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            if (login.equals(correctLogin) && password.equals(correctPassword)) {
                System.out.println("Авторизация успешна! Добро пожаловать, " + login + "!\n");
                break;
            } else {
                System.out.println("Неверный логин или пароль. Попробуйте снова.\n");
            }
        }

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Смартфон", 45000.0, Category.ELECTRONICS));
        catalog.add(new Product("Ноутбук", 80000.0, Category.ELECTRONICS));
        catalog.add(new Product("Футболка", 1500.0, Category.CLOTHING));
        catalog.add(new Product("Джинсы", 4000.0, Category.CLOTHING));
        catalog.add(new Product("Учебник по Java", 1200.0, Category.BOOKS));
        catalog.add(new Product("Роман", 650.0, Category.BOOKS));

        List<Product> cart = new ArrayList<>();

        while (true) {
            System.out.println("=========== МЕНЮ ===========");
            System.out.println("1. Посмотреть список каталогов");
            System.out.println("2. Посмотреть товары определенного каталога");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Посмотреть корзину и оформить покупку");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректную цифру.\n");
                continue;
            }
            if (choice == 0) {
                System.out.println("Спасибо за посещение нашего магазина! До свидания!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- Доступные каталоги ---");
                    int catIndex = 1;
                    for (Category cat : Category.values()) {
                        System.out.println(catIndex + ". " + cat.getTitle());
                        catIndex++;
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("\nВыберите каталог:");
                    Category[] categories = Category.values();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + ". " + categories[i].getTitle());
                    }
                    System.out.print("Номер каталога: ");
                    int selectedCatNum = Integer.parseInt(scanner.nextLine()) - 1;
                    if (selectedCatNum >= 0 && selectedCatNum < categories.length) {
                        Category selectedCategory = categories[selectedCatNum];
                        System.out.println("\nТовары в категории «" + selectedCategory.getTitle() + "»:");
                        for (Product p : catalog) {
                            if (p.category == selectedCategory) {
                                System.out.println(" - " + p);
                            }
                        }
                    } else {
                        System.out.println("Неверный номер каталога.");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("\n--- Список всех доступных товаров ---");
                    for (int i = 0; i < catalog.size(); i++) {
                        System.out.println((i + 1) + ". " + catalog.get(i) + " [" + catalog.get(i).category.getTitle() + "]");
                    }
                    System.out.print("Введите номер товара для добавления в корзину: ");
                    int productIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (productIndex >= 0 && productIndex < catalog.size()) {
                        Product added = catalog.get(productIndex);
                        cart.add(added);
                        System.out.println("Товар «" + added.name + "» успешно добавлен в корзину!");
                    } else {
                        System.out.println("Товар с таким номером не найден.");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("\n--- Ваша корзина ---");
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста. Нечего покупать!\n");
                        break;
                    }
                    double totalPrice = 0.0;
                    for (Product item : cart) {
                        System.out.println(" • " + item);
                        totalPrice += item.price;
                    }
                    System.out.println("Итого к оплате: " + totalPrice + " руб.");
                    System.out.print("Подтвердить покупку? (1 - Да, 2 - Отмена): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equals("1")) {
                        System.out.println("Поздравляем с покупкой на сумму " + totalPrice + " руб.! Заказ оформлен.");
                        cart.clear();
                    } else {
                        System.out.println("Покупка отложена. Товары остались в корзине.");
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("Неизвестный пункт меню. Выберите от 0 до 4.\n");
                    break;
            }
        }
        scanner.close();
    }
}