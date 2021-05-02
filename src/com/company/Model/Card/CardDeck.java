package com.company.Model.Card;

import com.company.Model.Card.Card;

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

}
