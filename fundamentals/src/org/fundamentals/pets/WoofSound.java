package org.fundamentals.pets;

public interface WoofSound extends Sound {
    default String soundType() {
        return "woof";
    }
}