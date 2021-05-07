package com.company.Model.Game;

import com.company.Model.Card.*;
import com.company.Model.Card.References.*;
import com.company.Model.GameBoard.Block;
import com.company.Model.GameBoard.Location;
import com.company.Model.Player.Player;

import java.util.ArrayList;

public class GameStarter {
    private GameLoop gameLoop;

    public GameStarter()
    {
        gameLoop = new GameLoop();
    }

    public void gameInit()
    {
        cardInit();
        boardInit();
        playersInit();

        gameLoop.init();
    }

    public void playersInit()
    {
        Location[] playerLocations = getDefaultPlayerLocations();
        Player[] players = new Player[SharedData.getInstance().PLAYER_COUNT];
        for (int i = 0; i < SharedData.getInstance().PLAYER_COUNT; i++)
        {
            References.Character character = References.Character.values()[i];
            Color color = Color.values()[i];
            players[i] = new Player(character.toString(), character, color, playerLocations[i], SharedData.getInstance().cardDeck.getRandomCards(SharedData.getInstance().PLAYER_HAND_SIZE));
            SharedData.getInstance().gameBoard.getBlocks()[playerLocations[i].getY()][playerLocations[i].getX()].setFull(true);
        }
        SharedData.getInstance().players = players;
    }

    public void boardInit()
    {
        int boardSize = SharedData.getInstance().BOARD_SIZE;
        Block[][] board = new Block[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                Block newBlock = new Block(new Location(j, i));
                board[i][j] = newBlock;
            }
        }

        // TODO init rooms
    }

    public void cardInit()
    {
        ArrayList<Card> cards = new ArrayList<>();
        for (RoomType roomType : RoomType.values())
        {
            cards.add(new Place(roomType.toString(), roomType));
        }
        for (References.Character character : References.Character.values())
        {
            cards.add(new Suspect(character.toString(), character));
        }
        for (Weapon weapon : Weapon.values())
        {
            cards.add(new Tool(weapon.toString(), weapon));
        }
        SharedData.getInstance().cardDeck = new CardDeck(cards);
        SharedData.getInstance().cardDeck.shuffle();
    }

    // default locations for max 6 players
    private Location[] getDefaultPlayerLocations()
    {
        int boardSize = SharedData.getInstance().BOARD_SIZE;
        return new Location[]{
                new Location(boardSize/3, 0),
                new Location(2*boardSize/3, 0),
                new Location(2*boardSize/3, boardSize-1),
                new Location(boardSize/3, boardSize-1),
                new Location(0, 2*boardSize/3),
                new Location(boardSize-1, boardSize/3),
        };
    }
}
