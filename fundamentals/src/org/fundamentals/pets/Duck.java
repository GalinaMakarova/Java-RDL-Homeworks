package org.fundamentals.pets;

public class Duck extends Pets implements Swimming, QuackSound {
    @Override
    protected String getName() {
        return "Duck";
    }
}