package Decorator;

public class Color extends Decorator {
    Matrioshka matrioshka;
    String color;

    public Color(Matrioshka matrioshka, String color) {
        this.matrioshka = matrioshka;
        this.color = color;
    }

    @Override
    public String getInfo() {
        return matrioshka.getInfo() + " Color:" + color;
    }
}
