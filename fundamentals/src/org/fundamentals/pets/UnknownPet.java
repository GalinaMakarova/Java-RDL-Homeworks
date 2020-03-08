package org.fundamentals.pets;

public class UnknownPet extends Pets {

    private String name;

    UnknownPet(String name) {
        this.name = name;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String actionType() {
        return "no action";
    }

    @Override
    public String soundType() {
        return "no sound";
    }
}
