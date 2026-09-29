package ru.mirea.task2.opt5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DogKennel {
    private List<Dog> dogs = new ArrayList<>();

    public void addDogs(Dog... newDogs) {
        dogs.addAll(Arrays.asList(newDogs));
    }

    public void printDogs() {
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel();

        Dog dog1 = new Dog("Шарик", 3);
        Dog dog2 = new Dog("Бобик", 5);
        Dog dog3 = new Dog("Рекс", 2);

        kennel.addDogs(dog1, dog2, dog3);

        System.out.println("Список собак в питомнике:");
        kennel.printDogs();
    }
}