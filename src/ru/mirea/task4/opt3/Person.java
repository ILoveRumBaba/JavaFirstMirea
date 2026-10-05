package ru.mirea.task4.opt3;

public class Person {
    String fullName;
    int age;

    public Person() {
    }
    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }
    public void move() {
        System.out.println(this.fullName + " перемещается");
    }
    public void talk() {
        System.out.println(this.fullName + " говорит");
    }
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.fullName = "Неизвестный";
        person1.age = 18;
        Person person2 = new Person("Иван Иванов", 20);
        person1.move();
        person1.talk();
        System.out.println(); // пустая строка для читаемости
        person2.move();
        person2.talk();
    }
}
