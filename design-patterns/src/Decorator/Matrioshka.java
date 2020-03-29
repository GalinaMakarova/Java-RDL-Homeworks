package Decorator;

public class Matrioshka extends AMatrioshka {
    public Matrioshka() {
        this.name = "Matrioshka";
    }
}

abstract class Decorator extends Matrioshka {
    public abstract String getInfo();
}