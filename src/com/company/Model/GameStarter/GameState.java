package com.company.Model.GameStarter;

import com.company.Model.GameBoard.Block;
import com.company.Model.Player.Player;

import java.util.HashMap;

public class GameState {
    private HashMap<Player, Block> locations;
    private boolean isFinished;

    public GameState(HashMap<Player, Block> locations, boolean isFinished) {
        this.locations = locations;
        this.isFinished = isFinished;
    }
}
