package com.company.Model.Card;

public abstract class Card {
    private final String NAME;

    public Card(String name) {
        NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return "{\"Card\":"
                + NAME
                + "}";
    }
}