package org.fundamentals.pets;

public interface Swimming extends Action {
    default String actionType() {
        return "swim around";
    }
}