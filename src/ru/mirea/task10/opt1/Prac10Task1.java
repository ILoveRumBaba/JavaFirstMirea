package ru.mirea.task10.opt1;

public class Prac10Task1 {
    static class Student {
        private String firstName;
        private String lastName;
        private String specialty;
        private int course;
        private String group;
        public Student(String firstName, String lastName, String specialty, int course, String group) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.specialty = specialty;
            this.course = course;
            this.group = group;
        }
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getSpecialty() { return specialty; }
        public void setSpecialty(String specialty) { this.specialty = specialty; }
        public int getCourse() { return course; }
        public void setCourse(int course) { this.course = course; }
        public String getGroup() { return group; }
        public void setGroup(String group) { this.group = group; }
        @Override
        public String toString() {
            return firstName + " " + lastName + ", " + specialty + ", курс " + course + ", гр. " + group;
        }
    }
    public static void main(String[] args) {
        Student s = new Student("Иван", "Иванов", "Программная инженерия", 2, "ПИ-21");
        System.out.println(s);
    }
}
