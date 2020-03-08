package org.fundamentals.pets;

public interface Running extends Action {
    default String actionType() {
        return "run run run";
    }
}