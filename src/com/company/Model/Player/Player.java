package com.company.Model.Player;

import com.company.Model.Card.Card;
import com.company.Model.Card.References;
import com.company.Model.GameBoard.Location;

import java.util.ArrayList;

public class Player {
    private final String NAME;
    private final References.Character CHARACTER;
    private final String COLOR;
    private final Location LOCATION;
    private final ArrayList<Card> cards;

    public Player(String name, References.Character character, String color, Location location) {
        NAME = name;
        CHARACTER = character;
        COLOR = color;
        LOCATION = location;
        cards = new ArrayList<>();
    }

    public String getNAME() {
        return NAME;
    }

    public References.Character getCHARACTER() {
        return CHARACTER;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public Location getLOCATION() {
        return LOCATION;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "{\"Player\":{"
                + "                        \"NAME\":\"" + NAME + "\""
                + ",                         \"CHARACTER\":\"" + CHARACTER + "\""
                + ",                         \"COLOR\":\"" + COLOR + "\""
                + ",                         \"LOCATION\":" + LOCATION
                + ",                         \"cards\":" + cards
                + "}}";
    }
}
