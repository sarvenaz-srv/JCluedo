package org.ta.jcluedo.model.gamelogic;

import org.ta.jcluedo.model.elements.board.*;
import org.ta.jcluedo.model.elements.cards.Place;
import org.ta.jcluedo.model.elements.cards.Suspect;
import org.ta.jcluedo.model.elements.cards.Tool;
import org.ta.jcluedo.model.elements.player.Player;
import org.ta.jcluedo.model.utils.SharedData;

import java.util.Random;

/**
 * Game Manager will make rule on every single player
 */
public class GameManager {

    private SharedData sharedData;
    private GameBoard gameBoard;

    public GameManager() {
        this.sharedData = SharedData.getInstance();
        this.gameBoard = sharedData.gameBoard;

    }

    /**
     * roll the dice and will ask player to decide and move using
     * {@link #rollTheDice() } ,{@link #moveCheck(Player, int[], int)}
     * then check decisions using
     * {@link #correctGuess(Suspect, Tool, Place)} &&
     * {@link #isOnDoor(Location)}
     *
     * @return true if the game was over
     */
    public boolean play(Player player) {
        boolean isGameFinished = false;

        //roll a dice for player and show the result to him
        int diceNumber = rollTheDice();
        //Messenger.SendDiceNumber(player , diceNumber);

        // then should ask the client side for move and check the answer
        int[] direction;
        do {
            direction = move(player);
        } while (!moveCheck(player, direction, diceNumber));

        if (isOnDoor(player.getLocation())) {
            //Send Player Wants to get into the Room or Not
            //Then Move Him to the Room
        }


        //Check possibility of finish
        return isGameFinished;
    }

    /**
     * @param player will be asked to get the directions
     * @return the direction of how he wants to move
     * (index 0 = vertical , index 1 = horizontal)
     */
    private int[] move(Player player) {
        // Will use Socket to ask the Client
        //Messenger.askWhereToGo(player);
        return new int[2];
    }

    /**
     * Check the possibility of moving
     * If could move the Location of Player will updated
     *
     * @param player     who wants to move
     * @param directions of where to go
     * @param diceNumber number of blocks he can move
     * @return false if the directions were invalid
     */
    private boolean moveCheck(Player player, int[] directions, int diceNumber) {
        int verticalMove = directions[0];
        int horizontalMove = directions[1];

        //If player wants to go no where
        if (verticalMove == 0 && horizontalMove == 0)
            return true;

        //Checking by diceNumber
        if (Math.abs(verticalMove) + Math.abs(horizontalMove) > diceNumber)
            return false;

        //Check by length of GameBoard Size
        if ((player.getLocation().getY() + verticalMove > sharedData.BOARD_SIZE ||
                player.getLocation().getY() + verticalMove <= 0)
                || (player.getLocation().getX() + horizontalMove > sharedData.BOARD_SIZE ||
                player.getLocation().getX() + horizontalMove <= 0))
            return false;

        Location current = player.getLocation();

        //Vertical Moving
        if (verticalMove > 0) { //Move Upward
            for (int i = verticalMove; i > 0; i--) {// to Check for each Block
                Location tempLocation = new Location(current.getX(), current.getY() + i);
                if (gameBoard.isFull(tempLocation))
                    return false;
            }
        } else { // Move Downward
            for (int i = verticalMove; i < 0; i++) {// to Check for each Block
                Location tempLocation = new Location(current.getX(), current.getY() + i);
                if (gameBoard.isFull(tempLocation))
                    return false;
            }

            //Horizontal Moving
            if (horizontalMove > 0) { //Move Rightward
                for (int i = horizontalMove; i > 0; i--) {
                    Location tempLocation = new Location(current.getX(), current.getY() + i);
                    if (gameBoard.isFull(tempLocation))
                        return false;
                }
            } else {//Move Leftward
                for (int i = horizontalMove; i < 0; i++) {
                    Location tempLocation = new Location(current.getX(), current.getY() + i);
                    if (gameBoard.isFull(tempLocation))
                        return false;
                }
            }

        }

        // Check if he wants to go directly to the rooms
        if (gameBoard.isRoom(new Location(current.getX() + horizontalMove,
                current.getY() + verticalMove)))
            return false;

        gameBoard.setFull(false, current); // empty the last location
        gameBoard.setFull(true, new Location(current.getX() + horizontalMove,
                current.getY() + verticalMove)); // fill the new block

        player.setLocation(new Location(current.getX() + horizontalMove,
                current.getY() + verticalMove));
        //update the location of player

        return true;
    }

    /**
     * @return true if the Location was a door
     */
    private boolean isOnDoor(Location playerLocation) {
        for (Block roomBLock : gameBoard.getRooms().keySet()) {
            Block room = gameBoard.getRooms().get(roomBLock).getDoor();
            if (room.getLocation().equals(playerLocation))
                return true;
        }
        return false;
    }

    private boolean correctGuess(Suspect suspect, Tool tool, Place place) {
        return suspect.equals(SharedData.getInstance().murderSuspect) &&
                tool.equals(SharedData.getInstance().murderWeapon) &&
                place.equals(SharedData.getInstance().murderPlace);
    }

    /**
     * act as a real dice
     *
     * @return result of dice
     */
    private int rollTheDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}
