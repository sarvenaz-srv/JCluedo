package com.company.Model.Game;

import com.company.Model.Card.CardDeck;
import com.company.Model.GameBoard.GameBoard;
import com.company.Model.Player.Player;

public class SharedData {
    private static SharedData instance;
    public static SharedData getInstance()
    {
        if (instance == null)
        {
            instance = new SharedData();
        }
        return instance;
    }
    public CardDeck cardDeck;
    public GameBoard gameBoard;
    public Player[] players;

    public final int BOARD_SIZE = 20;
    public final int PLAYER_COUNT = 6;
    public final int PLAYER_HAND_SIZE = 3;
    public final int ROOM_COUNT = 9;
    public final int DEFAULT_ROOM_HEIGHT = 3;
    public final int DEFAULT_ROOM_WIDTH = 3;
}
