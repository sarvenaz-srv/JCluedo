package com.company.Model.Player;

import com.company.Model.Card.Card;
import com.company.Model.Card.References;
import com.company.Model.Card.References.Color;
import com.company.Model.GameBoard.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private final String NAME;
    private final References.Character CHARACTER;
    private final Color COLOR;
    private final Location LOCATION;
    private final ArrayList<Card> cards;

    public Player(String name, References.Character character, Color color, Location location, ArrayList<Card> cards) {
        NAME = name;
        CHARACTER = character;
        COLOR = color;
        LOCATION = location;
        this.cards = cards;
    }

    public String getNAME() {
        return NAME;
    }

    public References.Character getCHARACTER() {
        return CHARACTER;
    }

    public Color getCOLOR() {
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
