package com.company.Model.Card;

import com.company.Model.Card.Card;
import com.company.Model.Player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CardDeck {

    private ArrayList<Card> cards;

    public CardDeck(){
        cards = new ArrayList<>();
    }

    public CardDeck(ArrayList<Card> cards){
        this.cards=cards;
    }

    public void addCard(Card cardToAdd){
        cards.add(cardToAdd);
    }

    public void addCards(Collection<Card> cardsToAdd){
        cards.addAll(cardsToAdd);
    }

    public void removeCard(Card cardToRemove){
        cards.remove(cardToRemove);
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getRandomCards(int number){
        ArrayList<Card> retVal = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<number; i++){
            Card card = cards.get(random.nextInt(cards.size()));
            retVal.add(card);
            cards.remove(card);
        }
        return retVal;
    }

    public ArrayList<Card> getLastCards(int number){
        ArrayList<Card> retVal = (ArrayList<Card>) cards.subList(cards.size()-number,cards.size()-1);
        return retVal;
    }

    public ArrayList<Card> getFirstCards(int number){
        ArrayList<Card> retVal = (ArrayList<Card>) cards.subList(0, number-1);
        return retVal;
    }

    public ArrayList<Card> getAllCards()
    {
        return cards;
    }


    public Tool getRandomTool(){
        ArrayList<Tool> allTools = new ArrayList<>();
        for(Card card : cards){
            if(card instanceof Tool){
                allTools.add((Tool) card);
            }
        }
        Random random = new Random();
        Tool retVal = allTools.get(random.nextInt(allTools.size()));
        cards.remove(retVal);
        return retVal;
    }

    public Suspect getRandomSuspect(){
        ArrayList<Suspect> allSuspects = new ArrayList<>();
        for(Card card : cards){
            if(card instanceof Suspect){
                allSuspects.add((Suspect) card);
            }
        }
        Random random = new Random();
        Suspect retVal = allSuspects.get(random.nextInt(allSuspects.size()));
        cards.remove(retVal);
        return retVal;
    }

    public Place getRandomPlace(){
        ArrayList<Place> allPlaces = new ArrayList<>();
        for(Card card : cards){
            if(card instanceof Place){
                allPlaces.add((Place) card);
            }
        }
        Random random = new Random();
        Place retVal = allPlaces.get(random.nextInt(allPlaces.size()));
        cards.remove(retVal);
        return retVal;
    }
}
