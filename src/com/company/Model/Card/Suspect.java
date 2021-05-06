package com.company.Model.Card;

public class Suspect extends Card{
    private final References.Character TYPE;

    public Suspect(String name, References.Character type) {
        super(name);
        TYPE = type;
    }

    public References.Character getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "{\"Suspect\":"
                + super.toString()
                + ",                         \"TYPE\":\"" + TYPE + "\""
                + "}";
    }
}
