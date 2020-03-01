package org.fundamentals.petsGenerics;

public class Main5 {
    public static void main(String[] args) {
        Pets pet = getPetByName(args[0]);
        System.out.println(pet.getDescription());
        System.out.println(pet.toString());
    }

    private static Pets getPetByName(String name) {
        switch (name.toLowerCase()) {
            case "cat":
                return new Pets("Cat", () -> "meow", () -> "purrrrr");
            case "dog":
                return new Pets("Dog", () -> "woof", () -> "run run run");
            case "duck":
                return new Pets("Duck", () -> "quack-quack", () -> "swim around");
            default:
                return new Pets(name, new UnknownPet(), new UnknownPet());
        }
    }
}
