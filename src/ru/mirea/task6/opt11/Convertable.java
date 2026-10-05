package ru.mirea.task6.opt11;

public interface Convertable {
    double convert(double celsius);
}
class KelvinConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}
class FahrenheitConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius * 1.8 + 32;
    }
}
class Main {
    public static void main(String[] args) {
        double celsius = 25.0;
        Convertable toKelvin = new KelvinConverter();
        Convertable toFahrenheit = new FahrenheitConverter();
        System.out.println("Исходная температура: " + celsius + " °C");
        System.out.println("По Кельвину:           " + toKelvin.convert(celsius) + " K");
        System.out.println("По Фаренгейту:         " + toFahrenheit.convert(celsius) + " °F");
    }
}
