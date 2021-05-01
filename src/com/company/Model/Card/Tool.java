package com.company.Model.Card;

public class Tool extends Card{
    private final References.Weapons TYPE;

    public Tool(String name, References.Weapons type) {
        super(name);
        TYPE = type;
    }

    public References.Weapons getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "{\"Tool\":"
                + super.toString()
                + ",                         \"TYPE\":\"" + TYPE + "\""
                + "}";
    }
}
