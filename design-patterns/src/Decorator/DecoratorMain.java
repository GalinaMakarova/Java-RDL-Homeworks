package Decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Matrioshka matrioshka1 = new Matrioshka();
        System.out.println(matrioshka1.getInfo());

        matrioshka1 = new Color(matrioshka1, "blue");
        System.out.println(matrioshka1.getInfo());

        Matrioshka matrioshka2 = new Matrioshka();
        matrioshka2 = new Color(matrioshka2, "red");
        System.out.println(matrioshka2.getInfo());

        Matrioshka matrioshka3 = new Matrioshka();
        matrioshka3 = new Color(matrioshka3, "violet");
        System.out.println(matrioshka3.getInfo());

        matrioshka2 = new Size(matrioshka2, "Big");
        System.out.println(matrioshka2.getInfo());

        Matrioshka matrioshka4 = new Matrioshka();
        matrioshka4 = new Color(matrioshka4, "green");
        matrioshka4 = new Size(matrioshka4, "Big");
        System.out.println(matrioshka4.getInfo());
    }
}
