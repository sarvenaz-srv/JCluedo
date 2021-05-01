package com.company.Model.Player;

import com.company.Model.Card.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class Notebook {
    private final HashMap<Card, Boolean> checklist;

    public Notebook(ArrayList<Card> cards) {
        checklist = new HashMap<>();

        for(Card card : cards) {
            checklist.put(card, false);
        }
    }

    public void check(Card card) {
        checklist.replace(card, true);
    }

    public void uncheck(Card card) {
        checklist.replace(card, false);
    }

    public HashMap<Card, Boolean> getChecklist() {
        return checklist;
    }

    @Override
    public String toString() {
        return "{\"Notebook\":{"
                + "                        \"checklist\":" + checklist
                + "}}";
    }
}
