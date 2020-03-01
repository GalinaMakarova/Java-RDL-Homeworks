package org.fundamentals.pets;

public abstract class Pets implements Action, Sound {
    protected abstract String getName();

    String getDescription() {
        return getName() + " says " + soundType() + " and can " + actionType() + ".";
    }
}
