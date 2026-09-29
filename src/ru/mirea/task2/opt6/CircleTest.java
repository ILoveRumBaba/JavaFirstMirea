package ru.mirea.task2.opt6;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0, 0.0, 0.0);
        Circle c2 = new Circle(7.5, 2.0, 3.0);
        Circle c3 = new Circle(5.0, 1.0, 1.0);

        System.out.println("Окружность 1: " + c1);
        System.out.println("Окружность 2: " + c2);
        System.out.println("Окружность 3: " + c3);

        System.out.println("\nПлощадь c1: " + String.format("%.2f", c1.getArea()));
        System.out.println("Длина окружности c1: " + String.format("%.2f", c1.getPerimeter()));

        // Проверка сравнения
        System.out.println("\n--- Сравнение окружностей ---");
        System.out.println("c1 равна c3? " + c1.equals(c3));
        System.out.println("c1 равна c2? " + c1.equals(c2));

        int cmp = c1.compareTo(c2);
        if (cmp < 0) {
            System.out.println("c1 меньше, чем c2");
        } else if (cmp > 0) {
            System.out.println("c1 больше, чем c2");
        } else {
            System.out.println("Окружности равны");
        }
    }
}
