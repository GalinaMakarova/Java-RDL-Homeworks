package org.fundamentals.petsGenerics;

public class UnknownPet implements Sound, Action {
    @Override
    public String soundType() {
        return "unknown";
    }

    @Override
    public String actionType() {
        return "unknown";
    }
}
