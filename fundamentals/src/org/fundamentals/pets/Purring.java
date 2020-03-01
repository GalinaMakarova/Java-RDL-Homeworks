package org.fundamentals.pets;

public interface Purring extends Action {
    default String actionType() {
        return "purrrrr";
    }
}