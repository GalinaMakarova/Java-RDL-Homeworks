package org.fundamentals.pets;

public interface MeowSound extends Sound {
    default String soundType() {
        return "meow";
    }
}