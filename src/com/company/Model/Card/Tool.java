package com.company.Model.Card;

public class Tool extends Card{
    private final References.Weapon TYPE;

    public Tool(String name, References.Weapon type) {
        super(name);
        TYPE = type;
    }

    public References.Weapon getTYPE() {
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
