package ru.mirea.task2.opt6;

public class Circle {
    private double radius;
    private double x;
    private double y;

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle(double radius) {
        this(radius, 0.0, 0.0);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }

    public boolean equals(Circle other) {
        return Double.compare(this.radius, other.radius) == 0;
    }

    @Override
    public String toString() {
        return String.format("Circle[r=%.2f, центр=(%.1f, %.1f), S=%.2f, C=%.2f]",
                radius, x, y, getArea(), getPerimeter());
    }
}