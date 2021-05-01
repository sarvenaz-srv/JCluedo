package com.company.Model.GameBoard;

import com.company.Model.Card.References;

public class Room {
    private Block space;
    private Block door;
    private int height;
    private int width;
    private Location center;
    private final References.RoomType TYPE;

    public Room(Block space, Block door, int height, int width, Location center, References.RoomType TYPE) {
        this.space = space;
        this.door = door;
        this.height = height;
        this.width = width;
        this.center = center;
        this.TYPE = TYPE;
    }

    public Block getSpace() {
        return space;
    }

    public void setSpace(Block space) {
        this.space = space;
    }

    public Block getDoor() {
        return door;
    }

    public void setDoor(Block door) {
        this.door = door;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Location getCenter() {
        return center;
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public References.RoomType getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "Room{" +
                "space=" + space +
                ", door=" + door +
                ", height=" + height +
                ", width=" + width +
                ", center=" + center +
                ", TYPE=" + TYPE +
                '}';
    }
}
