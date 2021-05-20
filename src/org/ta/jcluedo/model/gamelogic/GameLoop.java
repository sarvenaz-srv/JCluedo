package org.ta.jcluedo.model.gamelogic;

import org.ta.jcluedo.model.utils.SharedData;
import org.ta.jcluedo.model.utils.logger.LogLevels;
import org.ta.jcluedo.model.utils.logger.LoggingManager;

public class GameLoop {
    //Logger
    private static final LoggingManager logger = new LoggingManager(GameLoop.class.getName());
    //Take Control of Game
    private GameManager gameManager;
    private boolean isGameFinished;
    private SharedData sharedData;

    public GameLoop() {
        gameManager = new GameManager();
        sharedData = SharedData.getInstance();
        isGameFinished = false;
    }

    /**
     * Starts The Game
     */
    public void init() {
        logger.log("GameLoop Starts", LogLevels.INFO);
        for (int i = 0; i < sharedData.PLAYER_COUNT; i++) {
            logger.log("player : " + sharedData.players[i].getNAME() + " turn", LogLevels.INFO);

            isGameFinished = gameManager.play(sharedData.players[i]);
            if (isGameFinished) {
                logger.log("Game Finished", LogLevels.INFO);
                break;
            }
            if (i == SharedData.getInstance().PLAYER_COUNT - 1) {
                i = 0;
            }
        }
    }

}
