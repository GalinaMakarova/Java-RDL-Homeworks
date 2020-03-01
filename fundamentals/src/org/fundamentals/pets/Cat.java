package org.fundamentals.pets;

public class Cat extends Pets implements Purring, MeowSound {
    @Override
    protected String getName() {
        return "Cat";
    }
}