package ru.mirea.task4.opt2;

enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);
    private final int euroSize;
    Size(int euroSize) {
        this.euroSize = euroSize;
    }
    public String getDescription() {
        return "Взрослый размер";
    }
    public int getEuroSize() {
        return this.euroSize;
    }
}
interface MenClothing {
    void dressMan();
}
interface WomenClothing {
    void dressWomen();
}
abstract class Clothes {
    Size size;
    double price;
    String color;
    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}
class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Мужская футболка: размер " + size + " (евро: " + size.getEuroSize() +
                ", " + size.getDescription() + "), цена: " + price + " руб., цвет: " + color);
    }
    @Override
    public void dressWomen() {
        System.out.println("Женская футболка: размер " + size + " (евро: " + size.getEuroSize() +
                ", " + size.getDescription() + "), цена: " + price + " руб., цвет: " + color);
    }
}
class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Мужские штаны:    размер " + size + " (евро: " + size.getEuroSize() +
                ", " + size.getDescription() + "), цена: " + price + " руб., цвет: " + color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женские штаны:    размер " + size + " (евро: " + size.getEuroSize() +
                ", " + size.getDescription() + "), цена: " + price + " руб., цвет: " + color);
    }
}
class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressWomen() {
        System.out.println("Юбка:             размер " + size + " (евро: " + size.getEuroSize() +
                ", " + size.getDescription() + "), цена: " + price + " руб., цвет: " + color);
    }
}
class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Галстук:          размер " + size + " (евро: " + size.getEuroSize() +
                ", " + size.getDescription() + "), цена: " + price + " руб., цвет: " + color);
    }
}
public class Atelier {
    public void dressMan(Clothes[] clothes) {
        System.out.println("ОДЕВАЕМ МУЖЧИНУ");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                ((MenClothing) item).dressMan();
            }
        }
    }

    public void dressWomen(Clothes[] clothes) {
        System.out.println("ОДЕВАЕМ ЖЕНЩИНУ");
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                ((WomenClothing) item).dressWomen();
            }
        }
    }

    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[] {
                new TShirt(Size.XXS, 1200.0, "Белый"),
                new Pants(Size.M, 3500.0, "Синий"),
                new Skirt(Size.S, 2800.0, "Красный"),
                new Tie(Size.L, 1500.0, "Черный")
        };

        Atelier atelier = new Atelier();
        atelier.dressMan(clothes);
        System.out.println();
        atelier.dressWomen(clothes);
    }
}
