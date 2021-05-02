package com.company.Model.GameStarter;

public class GameStarter {
    private GameLoop gameLoop;
    private CardDesk cardDesk;

    public void gameInit(){}
    public void playersInit(){}
    public void boardInit(){}
    public void cardInit(){}
    public GameState makeFirstState(){
        return new GameState();
    }
}
