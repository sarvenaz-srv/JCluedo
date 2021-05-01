package com.company.Model.Card;

public class Place extends Card{
    private final References.Rooms TYPE;


    protected Place(String name, References.Rooms type) {
        super(name);
        TYPE = type;
    }

    public References.Rooms getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "{\"Place\":"
                + super.toString()
                + ",                         \"TYPE\":\"" + TYPE + "\""
                + "}";
    }
}
