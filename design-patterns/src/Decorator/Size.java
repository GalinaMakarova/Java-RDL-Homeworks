package Decorator;

public class Size extends Decorator {
    Matrioshka matrioshka;
    String size;

    public Size(Matrioshka matrioshka, String size) {
        this.matrioshka = matrioshka;
        this.size = size;
    }

    @Override
    public String getInfo() {
        return matrioshka.getInfo() + " Size:" + size;
    }

}
