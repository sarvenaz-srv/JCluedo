package com.company.Model.GameBoard;

import java.util.Arrays;
import java.util.HashMap;

public class GameBoard {
    private Block[][] blocks;
    private HashMap<Room, Block> rooms;

    public GameBoard(Block[][] blocks, HashMap<Room, Block> rooms) {
        this.blocks = blocks;
        this.rooms = rooms;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    public HashMap<Room, Block> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<Room, Block> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "blocks=" + Arrays.toString(blocks) +
                ", rooms=" + rooms +
                '}';
    }
}
