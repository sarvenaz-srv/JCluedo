package com.company.Model.Card;

public abstract class Card {
    final String NAME;

    protected Card(String name) {
        NAME = name;
    }

    public String getNAME() {
        return NAME;
    }
}