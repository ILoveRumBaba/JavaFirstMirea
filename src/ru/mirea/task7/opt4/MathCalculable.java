package ru.mirea.task7.opt4;

interface MathCalculable {
    double PI = 3.141592653589793;
    double pow(double base, double exponent);
    double absComplex(double real, double imaginary);
}
class MathFunc implements MathCalculable {
    @Override
    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    @Override
    public double absComplex(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
    public double circleLength(double radius) {
        return 2 * PI * radius;
    }
}

class MainMath {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc();
        System.out.println("2 в степени 4: " + mc1.pow(2, 4));
        System.out.println("Модуль комплексного числа (3 + 4i): " + mc1.absComplex(3, 4));
        MathFunc mf = new MathFunc();
        System.out.println("Длина окружности с радиусом 5: " + mf.circleLength(5));
    }
}
