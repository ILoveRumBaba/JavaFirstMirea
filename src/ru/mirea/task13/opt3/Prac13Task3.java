package ru.mirea.task13.opt3;
import java.util.StringTokenizer;

public class Prac13Task3 {
    static class Address {
        String country, region, city, street, house, building, flat;
        public void parseSplit(String s) {
            String[] p = s.split(",");
            country = p[0].trim();
            region = p[1].trim();
            city = p[2].trim();
            street = p[3].trim();
            house = p[4].trim();
            building = p[5].trim();
            flat = p[6].trim();
        }
        public void parseTokenizer(String s) {
            StringTokenizer st = new StringTokenizer(s, ",.;-");
            country = st.nextToken().trim();
            region = st.nextToken().trim();
            city = st.nextToken().trim();
            street = st.nextToken().trim();
            house = st.nextToken().trim();
            building = st.nextToken().trim();
            flat = st.nextToken().trim();
        }
        @Override
        public String toString() {
            return country + " | " + region + " | " + city + " | " + street + " | " + house + " | " + building + " | " + flat;
        }
    }
    public static void main(String[] args) {
        Address a = new Address();
        a.parseSplit("Россия, МО, Москва, Ленина, 10, 1, 5");
        System.out.println(a);
        a.parseSplit("Беларусь, Минская, Минск, Мира, 20, 2, 12");
        System.out.println(a);
        a.parseTokenizer("Россия; ЛО. СПб-Невский, 15; 3. 40");
        System.out.println(a);
        a.parseTokenizer("Казахстан. Алматинская; Алматы-Абая, 5; 1-8");
        System.out.println(a);
    }
}
