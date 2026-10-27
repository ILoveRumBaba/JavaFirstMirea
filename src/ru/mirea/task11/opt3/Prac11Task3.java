package ru.mirea.task11.opt3;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Prac11Task3 {
    static class Student {
        String name;
        Date birthDate;
        public Student(String name, Date birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }
        public String formatBirthDate(int style) {
            DateFormat df = DateFormat.getDateInstance(style, new Locale("ru"));
            return df.format(birthDate);
        }
        @Override
        public String toString() {
            return "Студент: " + name + ", дата рождения: " + formatBirthDate(DateFormat.MEDIUM);
        }
    }
    public static void main(String[] args) {
        Student s = new Student("Иван", new Date());
        System.out.println(s);
        System.out.println("Короткий: " + s.formatBirthDate(DateFormat.SHORT));
        System.out.println("Средний:  " + s.formatBirthDate(DateFormat.MEDIUM));
        System.out.println("Полный:   " + s.formatBirthDate(DateFormat.FULL));
    }
}
