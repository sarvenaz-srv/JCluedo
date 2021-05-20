package org.ta.jcluedo.model.utils;

import org.ta.jcluedo.model.elements.cards.CardDeck;
import org.ta.jcluedo.model.elements.cards.Place;
import org.ta.jcluedo.model.elements.cards.Suspect;
import org.ta.jcluedo.model.elements.cards.Tool;
import org.ta.jcluedo.model.elements.board.GameBoard;
import org.ta.jcluedo.model.elements.player.Player;

public class SharedData {
    private static SharedData instance;

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public CardDeck cardDeck;
    public GameBoard gameBoard;
    public Player[] players;
    public Place murderPlace;
    public Suspect murderSuspect;
    public Tool murderWeapon;

    public final int BOARD_SIZE = 20;
    public final int PLAYER_COUNT = 6;
    public final int PLAYER_HAND_SIZE = 3;
    public final int ROOM_COUNT = 9;
    public final int DEFAULT_ROOM_HEIGHT = 3;
    public final int DEFAULT_ROOM_WIDTH = 3;

    public final char ESC_CODE = 0x1B;


}
