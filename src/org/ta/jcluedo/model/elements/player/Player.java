package org.ta.jcluedo.model.elements.player;

import org.ta.jcluedo.model.elements.cards.Card;
import org.ta.jcluedo.model.elements.cards.References;
import org.ta.jcluedo.model.elements.cards.References.Color;
import org.ta.jcluedo.model.elements.board.Location;

import java.util.ArrayList;

public class Player {
    private final String NAME;
    private final References.Character CHARACTER;
    private final Color COLOR;
    private Location location;
    private ArrayList<Card> hand;
    private Notebook notebook;

    public Player(String name, References.Character character, Color color, Location location, Notebook notebook) {
        NAME = name;
        CHARACTER = character;
        COLOR = color;
        this.location = location;
        this.notebook = notebook;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void setHand(ArrayList<Card> hand)
    {
        this.hand = hand;
    }

    public Notebook getNotebook()
    {
        return notebook;
    }

    @Override
    public String toString() {
        return "{\"Player\":{"
                + "                        \"NAME\":\"" + NAME + "\""
                + ",                         \"CHARACTER\":\"" + CHARACTER + "\""
                + ",                         \"COLOR\":\"" + COLOR + "\""
                + ",                         \"LOCATION\":" + location
                + ",                         \"cards\":" + hand
                + "}}";
    }
}
