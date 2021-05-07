package com.company.Model.Game;

public class GameLoop {
    private GameManager gameManager;
    private boolean isGameFinished;

    public GameLoop()
    {
        gameManager = new GameManager();
        isGameFinished = false;
    }

    public void init()
    {
        for (int i = 0; i < SharedData.getInstance().PLAYER_COUNT; i++)
        {
            isGameFinished = gameManager.play(SharedData.getInstance().players[i]);
            if (isGameFinished)
            {
                break;
            }
            if (i == SharedData.getInstance().PLAYER_COUNT - 1)
            {
                i = 0;
            }
        }
    }

}
