package ru.mirea.task2.opt4;

public interface ShopInterface {
    void addComputer(Computer computer);
    void removeComputer(String name);
    Computer findComputer(String name);
    void printComputers();
}
