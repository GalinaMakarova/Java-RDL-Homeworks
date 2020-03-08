package org.fundamentals.pets;

public class Dog extends Pets implements Running, WoofSound {
    @Override
    protected String getName() {
        return "Dog";
    }
}