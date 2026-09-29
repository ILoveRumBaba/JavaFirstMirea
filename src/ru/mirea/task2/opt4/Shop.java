package ru.mirea.task2.opt4;

import java.util.ArrayList;
import java.util.List;

public class Shop implements ShopInterface {
    private List<Computer> computers = new ArrayList<>();

    @Override
    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Компьютер \"" + computer.getName() + "\" добавлен.");
    }

    @Override
    public void removeComputer(String name) {
        Computer found = findComputer(name);
        if (found != null) {
            computers.remove(found);
            System.out.println("Компьютер \"" + name + "\" успешно удален.");
        } else {
            System.out.println("Компьютер \"" + name + "\" не найден.");
        }
    }

    @Override
    public Computer findComputer(String name) {
        for (Computer c : computers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void printComputers() {
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст.");
            return;
        }
        System.out.println("Список компьютеров в магазине:");
        for (Computer c : computers) {
            System.out.println(c);
        }
    }
}