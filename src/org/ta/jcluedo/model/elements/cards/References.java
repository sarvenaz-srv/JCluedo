package org.ta.jcluedo.model.elements.cards;

public class References {

    public enum Character {
        PLUM, WHITE, SCARLET, GREEN, MUSTARD, PEACOCK
    }

    public enum Weapon {
        ROPE, DAGGER, WRENCH, PISTOL, CANDLESTICK, PIPE
    }

    public enum RoomType {
        COURTYARD, GAME, STUDY, DINING, GARAGE, LIVING, KITCHEN, BEDROOM, BATHROOM
    }

    public enum Color {
        PURPLE(5), WHITE(7), RED(1), GREEN(2), YELLOW(3), BLUE(4);

        Color(int i) {

        }
    }
}
