package org.ta.jcluedo.model.elements.board;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Is the Board of the Game
 */
public class GameBoard {
    private Block[][] blocks; // is a 2D matrix
    private HashMap<Block, Room> rooms;

    public GameBoard(Block[][] blocks, HashMap<Block, Room> rooms) {
        this.blocks = blocks;
        this.rooms = rooms;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    public HashMap<Block, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<Block, Room> rooms) {
        this.rooms = rooms;
    }

    public void setFull(boolean isFull, Location location) {
        blocks[location.getX()][location.getX()].setFull(isFull);
    }

    public boolean isFull(Location location) {
        return blocks[location.getX()][location.getY()].isFull();
    }

    /**
     * @return true if the location was a Room
     */
    public boolean isRoom(Location location) {
        for (Block room : rooms.keySet()) {
            if (room.getLocation().equals(location))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "blocks=" + Arrays.toString(blocks) +
                ", rooms=" + rooms +
                '}';
    }
}
