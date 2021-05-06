package com.company.Model.Card;

public class Place extends Card{
    private final References.RoomType TYPE;


    public Place(String name, References.RoomType type) {
        super(name);
        TYPE = type;
    }

    public References.RoomType getTYPE() {
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
