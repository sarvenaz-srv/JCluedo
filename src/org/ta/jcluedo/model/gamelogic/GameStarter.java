package org.ta.jcluedo.model.gamelogic;

import org.ta.jcluedo.model.elements.cards.*;
import org.ta.jcluedo.model.elements.cards.References.*;
import org.ta.jcluedo.model.elements.board.Block;
import org.ta.jcluedo.model.elements.board.GameBoard;
import org.ta.jcluedo.model.elements.board.Location;
import org.ta.jcluedo.model.elements.board.Room;
import org.ta.jcluedo.model.elements.player.Notebook;
import org.ta.jcluedo.model.elements.player.Player;
import org.ta.jcluedo.model.utils.SharedData;
import org.ta.jcluedo.model.utils.logger.LogLevels;
import org.ta.jcluedo.model.utils.logger.LoggingManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This Class is an initializer for all game elements and non static parts
 */
public class GameStarter {
    private static final LoggingManager logger = new LoggingManager(GameStarter.class.getName());
    private GameLoop gameLoop;

    public GameStarter() {
        gameLoop = new GameLoop();
    }

    public void gameInit() {
        cardInit();
        boardInit();
        playersInit();
        murderInit();
        gameLoop.init();
    }

    /**
     * Initialize each Player of the Game
     */
    public void playersInit() {
        Location[] playerLocations = getDefaultPlayerLocations();
        Player[] players = new Player[SharedData.getInstance().PLAYER_COUNT];
        for (int i = 0; i < SharedData.getInstance().PLAYER_COUNT; i++) {
            References.Character character = References.Character.values()[i];
            Color color = Color.values()[i];
            Notebook notebook = new Notebook(new ArrayList<Card>(SharedData.getInstance().cardDeck.getAllCards()));

            players[i] = new Player(character.toString(), character, color, playerLocations[i], notebook);
            SharedData.getInstance().gameBoard.getBlocks()
                    [playerLocations[i].getY()][playerLocations[i].getX()].setFull(true);
        }
        for (int i = 0; i < SharedData.getInstance().PLAYER_COUNT; i++) {
            players[i].setHand(SharedData.getInstance().cardDeck.getRandomCards
                    (SharedData.getInstance().PLAYER_HAND_SIZE));
        }
        SharedData.getInstance().players = players;
        logger.log("Players are initialized ", LogLevels.INFO);
    }

    /**
     * Initialize the elements of Game Board
     */
    public void boardInit() {
        int boardSize = SharedData.getInstance().BOARD_SIZE;
        Block[][] board = new Block[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) { // for each of Blocks
            for (int j = 0; j < boardSize; j++) {
                Block newBlock = new Block(new Location(j, i));
                board[i][j] = newBlock;
            }
        }

        HashMap<Location, Location> roomLocations = getDefaultRoomLocations();
        HashMap<Block, Room> rooms = new HashMap<>();
        int count = 0;
        for (Location roomLocation : roomLocations.keySet()) {
            Block roomBlock = board[roomLocation.getY()][roomLocation.getX()];
            Block doorBlock = board[roomLocations.get(roomLocation).getY()][roomLocations.get(roomLocation).getX()];
            Room room = new Room(roomBlock, doorBlock, SharedData.getInstance().DEFAULT_ROOM_HEIGHT,
                    SharedData.getInstance().DEFAULT_ROOM_WIDTH, RoomType.values()[count]);
            rooms.put(roomBlock, room);
            count++;
        }

        SharedData.getInstance().gameBoard = new GameBoard(board, rooms);
        logger.log("GameBoard are initialized ", LogLevels.INFO);
    }

    public void cardInit() {
        ArrayList<Card> cards = new ArrayList<>();
        for (RoomType roomType : RoomType.values()) {
            cards.add(new Place(roomType.toString(), roomType));
        }
        for (References.Character character : References.Character.values()) {
            cards.add(new Suspect(character.toString(), character));
        }
        for (Weapon weapon : Weapon.values()) {
            cards.add(new Tool(weapon.toString(), weapon));
        }
        SharedData.getInstance().cardDeck = new CardDeck(cards);
        SharedData.getInstance().cardDeck.shuffle();
        logger.log("Cards are initialized ", LogLevels.INFO);
    }

    /**
     * Randomly choose a murder
     */
    public void murderInit() {
        SharedData.getInstance().murderPlace = SharedData.getInstance().cardDeck.getRandomPlace();
        SharedData.getInstance().murderSuspect = SharedData.getInstance().cardDeck.getRandomSuspect();
        SharedData.getInstance().murderWeapon = SharedData.getInstance().cardDeck.getRandomTool();
        logger.log("Murder are initialized ", LogLevels.INFO);
    }

    /**
     * @return the Location of Players
     */
    @Deprecated(since = "This job Should handle On ConfigFiles")
    private Location[] getDefaultPlayerLocations() {
        int boardSize = SharedData.getInstance().BOARD_SIZE;
        return new Location[]{
                new Location(boardSize / 3, 0),
                new Location(2 * boardSize / 3, 0),
                new Location(2 * boardSize / 3, boardSize - 1),
                new Location(boardSize / 3, boardSize - 1),
                new Location(0, 2 * boardSize / 3),
                new Location(boardSize - 1, boardSize / 3),
        };
    }

    /**
     * @return the Location of  Rooms
     */
    @Deprecated(since = "THis job Should handle On Config Files Like XMLs ,YMLs, JSONs")
    private HashMap<Location, Location> getDefaultRoomLocations() {
        int boardSize = SharedData.getInstance().BOARD_SIZE;
        HashMap<Location, Location> roomWithDoor = new HashMap<>();

        roomWithDoor.put(new Location(0, 0), new Location(0, 1));
        roomWithDoor.put(new Location(0, boardSize - 1), new Location(1, boardSize - 1));

        roomWithDoor.put(new Location(boardSize - 1, boardSize - 1),
                new Location(boardSize - 2, boardSize - 1));

        roomWithDoor.put(new Location(boardSize - 1, 0), new Location(boardSize - 1, 1));

        roomWithDoor.put(new Location(boardSize - 1, boardSize / 2),
                new Location(boardSize - 2, boardSize / 2));

        roomWithDoor.put(new Location(boardSize / 2, boardSize - 1),
                new Location(boardSize / 2, boardSize - 2));

        roomWithDoor.put(new Location(boardSize / 2, 0), new Location(boardSize / 2, 1));
        roomWithDoor.put(new Location(0, boardSize / 2), new Location(1, boardSize / 2));

        roomWithDoor.put(new Location(boardSize / 2, boardSize / 2),
                new Location(boardSize / 2 + 1, boardSize / 2));

        return roomWithDoor;
    }
}
