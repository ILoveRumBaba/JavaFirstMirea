package ru.mirea.task4.opt2;

public class Phone {
    String number;
    String model;
    double weight;
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }
    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }
    public Phone() {
    }
    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }
    public void receiveCall(String name, String number) {
        System.out.println("Звонит " + name + ", номер: " + number);
    }
    public String getNumber() {
        return this.number;
    }
    public void sendMessage(String... numbers) {
        System.out.println("Отправка сообщений на следующие номера:");
        for (String num : numbers) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("+7 (999) 111-22-33", "iPhone 15", 171.0);
        Phone phone2 = new Phone("+7 (999) 444-55-66", "Samsung S24", 167.0);
        Phone phone3 = new Phone("+7 (999) 777-88-99", "Xiaomi 14", 193.0);
        System.out.println("2) Значения переменных объектов");
        System.out.println("Телефон 1: Модель: " + phone1.model + ", Номер: " + phone1.number + ", Вес: " + phone1.weight + " г");
        System.out.println("Телефон 2: Модель: " + phone2.model + ", Номер: " + phone2.number + ", Вес: " + phone2.weight + " г");
        System.out.println("Телефон 3: Модель: " + phone3.model + ", Номер: " + phone3.number + ", Вес: " + phone3.weight + " г");
        System.out.println();

        System.out.println("6) Вызов receiveCall и getNumber");
        phone1.receiveCall("Алексей");
        System.out.println("Номер: " + phone1.getNumber());

        phone2.receiveCall("Мария");
        System.out.println("Номер: " + phone2.getNumber());

        phone3.receiveCall("Иван");
        System.out.println("Номер: " + phone3.getNumber());
        System.out.println();

        System.out.println("12) Перегруженный receiveCall (2 аргумента)");
        phone1.receiveCall("Дмитрий", "+7 (900) 000-00-00");
        System.out.println();

        System.out.println("14) Метод sendMessage");
        phone1.sendMessage("+7 (916) 111-11-11", "+7 (926) 222-22-22", "+7 (903) 333-33-33");
    }
}
