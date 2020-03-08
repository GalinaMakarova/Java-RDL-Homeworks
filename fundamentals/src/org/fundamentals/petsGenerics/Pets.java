package org.fundamentals.petsGenerics;

public class Pets<S extends Sound, A extends Action> implements ObjectsWithSoundAndAction {
    private String name;
    private S sound;
    private A action;

    public Pets(String name, S sound, A action) {
        this.name = name;
        this.sound = sound;
        this.action = action;
    }

    String getDescription() {
        return name + " says " + sound.soundType() + " and can " + action.actionType() + ".";
    }

    @Override
    public S getSound() {
        return sound;
    }

    @Override
    public A getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Pet<" + sound.getClass().getName() + "," + action.getClass().getName() + ">";
    }
}
