package com.company.Model.Game;

import com.company.Model.Card.*;
import com.company.Model.Card.References.*;
import com.company.Model.GameBoard.Block;
import com.company.Model.GameBoard.GameBoard;
import com.company.Model.GameBoard.Location;
import com.company.Model.GameBoard.Room;
import com.company.Model.Player.Notebook;
import com.company.Model.Player.Player;

import java.util.ArrayList;
import java.util.HashMap;

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
        murderInit();
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
            Notebook notebook = new Notebook(new ArrayList<Card>(SharedData.getInstance().cardDeck.getAllCards()));
            players[i] = new Player(character.toString(), character, color, playerLocations[i], notebook);
            SharedData.getInstance().gameBoard.getBlocks()[playerLocations[i].getY()][playerLocations[i].getX()].setFull(true);
        }
        for (int i = 0; i < SharedData.getInstance().PLAYER_COUNT; i++)
        {
            players[i].setHand(SharedData.getInstance().cardDeck.getRandomCards(SharedData.getInstance().PLAYER_HAND_SIZE));
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

        HashMap<Location, Location> roomLocations = getDefaultRoomLocations();
        HashMap<Block, Room> rooms = new HashMap<>();
        int count = 0;
        for (Location roomLocation : roomLocations.keySet())
        {
            Block roomBlock = board[roomLocation.getY()][roomLocation.getX()];
            Block doorBlock = board[roomLocations.get(roomLocation).getY()][roomLocations.get(roomLocation).getX()];
            Room room = new Room(roomBlock, doorBlock, SharedData.getInstance().DEFAULT_ROOM_HEIGHT, SharedData.getInstance().DEFAULT_ROOM_WIDTH, RoomType.values()[count]);
            rooms.put(roomBlock, room);
            count++;
        }

        SharedData.getInstance().gameBoard = new GameBoard(board, rooms);
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

    public void murderInit(){
        SharedData.getInstance().murderPlace = SharedData.getInstance().cardDeck.getRandomPlace();
        SharedData.getInstance().murderSuspect = SharedData.getInstance().cardDeck.getRandomSuspect();
        SharedData.getInstance().murderWeapon = SharedData.getInstance().cardDeck.getRandomTool();
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

    private HashMap<Location, Location> getDefaultRoomLocations() {
        int boardSize = SharedData.getInstance().BOARD_SIZE;
        HashMap<Location, Location> roomWithDoor = new HashMap<>();
        roomWithDoor.put(new Location(0, 0), new Location(0, 1));
        roomWithDoor.put(new Location(0, boardSize - 1), new Location(1, boardSize - 1));
        roomWithDoor.put(new Location(boardSize - 1, boardSize - 1), new Location(boardSize - 2, boardSize - 1));
        roomWithDoor.put(new Location(boardSize - 1, 0), new Location(boardSize - 1, 1));
        roomWithDoor.put(new Location(boardSize - 1, boardSize / 2), new Location(boardSize - 2, boardSize / 2));
        roomWithDoor.put(new Location(boardSize / 2, boardSize - 1), new Location(boardSize / 2, boardSize - 2));
        roomWithDoor.put(new Location(boardSize / 2, 0), new Location(boardSize / 2, 1));
        roomWithDoor.put(new Location(0, boardSize / 2), new Location(1, boardSize / 2));
        roomWithDoor.put(new Location(boardSize / 2, boardSize / 2), new Location(boardSize / 2 + 1, boardSize / 2));
        return roomWithDoor;
    }
}
