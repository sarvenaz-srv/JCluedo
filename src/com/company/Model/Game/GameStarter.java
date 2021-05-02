package com.company.Model.Game;

import com.company.Model.Card.CardDeck;

public class GameStarter {
    private GameLoop gameLoop;
    private CardDeck cardDeck;

    public void gameInit(){}
    public void playersInit(){}
    public void boardInit(){}
    public void cardInit(){}
    public GameState makeFirstState(){
        return new GameState(null, false);
    }
}
