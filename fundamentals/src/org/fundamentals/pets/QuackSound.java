package org.fundamentals.pets;

public interface QuackSound extends Sound {
    default String soundType() {
        return "quack-quack";
    }
}