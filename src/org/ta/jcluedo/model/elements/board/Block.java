package org.ta.jcluedo.model.elements.board;

public class Block {
    private Location location;
    private boolean isFull;

    public Block(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "Block{" +
                "location=" + location +
                ", isFull=" + isFull +
                '}';
    }

}
