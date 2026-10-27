package ru.mirea.task13.opt2;

public class Prac13Task2 {
    static class Person {
        private String lastName, firstName, middleName;
        public Person(String lastName, String firstName, String middleName) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
        }
        public String getFullName() {
            StringBuilder sb = new StringBuilder(lastName);
            if (firstName != null && !firstName.isEmpty()) {
                sb.append(" ").append(firstName.charAt(0)).append(".");
                if (middleName != null && !middleName.isEmpty()) {
                    sb.append(middleName.charAt(0)).append(".");
                }
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        System.out.println(new Person("Иванов", "Иван", "Иванович").getFullName());
        System.out.println(new Person("Иванов", "Иван", "").getFullName());
        System.out.println(new Person("Иванов", null, null).getFullName());
    }
}
