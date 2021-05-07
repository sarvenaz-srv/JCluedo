package com.company.Model.Game;

import com.company.Model.Card.*;
import com.company.Model.Card.References.*;
import com.company.Model.GameBoard.Block;
import com.company.Model.GameBoard.Location;
import com.company.Model.GameBoard.Room;
import com.company.Model.Player.Player;

import java.lang.Character;
import java.util.ArrayList;
import java.util.Arrays;

public class GameStarter {
    private GameLoop gameLoop;
    private CardDeck cardDeck;

    public void gameInit()
    {
        cardInit();
        boardInit();
        playersInit();
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
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(
           new Place(References.RoomType.BATHROOM.toString(), References.RoomType.BATHROOM),
           new Place(References.RoomType.BEDROOM.toString(), References.RoomType.BEDROOM),
           new Place(References.RoomType.KITCHEN.toString(), References.RoomType.KITCHEN),
           new Place(References.RoomType.COURTYARD.toString(), References.RoomType.COURTYARD),
           new Place(References.RoomType.DINING.toString(), References.RoomType.DINING),
           new Place(References.RoomType.GARAGE.toString(), References.RoomType.GARAGE),
           new Place(References.RoomType.GAME.toString(), References.RoomType.GAME),
           new Place(References.RoomType.STUDY.toString(), References.RoomType.STUDY),
           new Place(References.RoomType.LIVING.toString(), References.RoomType.LIVING),
           new Suspect(References.Character.GREEN.toString(), References.Character.GREEN),
           new Suspect(References.Character.WHITE.toString(), References.Character.WHITE),
           new Suspect(References.Character.MUSTARD.toString(), References.Character.MUSTARD),
           new Suspect(References.Character.SCARLET.toString(), References.Character.SCARLET),
           new Suspect(References.Character.PEACOCK.toString(), References.Character.PEACOCK),
           new Suspect(References.Character.PLUM.toString(), References.Character.PLUM),
           new Tool(References.Weapon.CANDLESTICK.toString(), References.Weapon.CANDLESTICK),
           new Tool(References.Weapon.DAGGER.toString(), References.Weapon.DAGGER),
           new Tool(References.Weapon.PIPE.toString(), References.Weapon.PIPE),
           new Tool(References.Weapon.PISTOL.toString(), References.Weapon.PISTOL),
           new Tool(References.Weapon.ROPE.toString(), References.Weapon.ROPE),
           new Tool(References.Weapon.WRENCH.toString(), References.Weapon.WRENCH)
        ));
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
