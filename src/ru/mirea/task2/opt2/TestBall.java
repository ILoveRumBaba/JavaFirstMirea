package ru.mirea.task2.opt2;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball(10.0, 20.0);
        System.out.println("Создан мяч b1: " + b1);

        b1.move(5.5, -2.0);
        System.out.println("После move(5.5, -2.0): " + b1);

        Ball b2 = new Ball();
        System.out.println("Создан мяч b2: " + b2);

        b2.setXY(3.0, 7.5);
        System.out.println("После setXY(3.0, 7.5): " + b2);

        b2.setX(15.0);
        b2.setY(25.0);
        System.out.println("Координата X: " + b2.getX());
        System.out.println("Координата Y: " + b2.getY());
    }
}
