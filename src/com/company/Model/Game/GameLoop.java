package com.company.Model.Game;

public class GameLoop {
    private GameManager gameManager;
    private boolean isGameFinished;

    public GameLoop()
    {
        gameManager = new GameManager();
        isGameFinished = false;
    }

    public void init(){}

}
