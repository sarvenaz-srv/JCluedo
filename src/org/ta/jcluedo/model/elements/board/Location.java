package org.ta.jcluedo.model.elements.board;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{\"Location\":{"
                + "                        \"x\":\"" + x + "\""
                + ",                         \"y\":\"" + y + "\""
                + "}}";
    }

    @Override
    public boolean equals(Object obj) {
        Location location = (Location) obj;
        if (this.x == location.getX() && this.y == location.getY())
            return true;
        return false;
    }
}