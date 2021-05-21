package org.ta.jcluedo.controller;

import org.ta.jcluedo.model.gamelogic.GameStarter;
import org.ta.jcluedo.model.utils.logger.LogLevels;
import org.ta.jcluedo.model.utils.logger.LoggingManager;
import org.ta.jcluedo.view.GameFrame;


/**
 * This is the CLass that Runs at first
 */
public class MainController {

    private static final LoggingManager logger = new LoggingManager(MainController.class.getName());
    private  GameFrame gameFrame;
    /**
     * Show The MainMenu and  get ready to read commands
     */
    public void start() {
        logger.log("Program Starts", LogLevels.INFO); // make log
        // Here Should show a mainMenu then ask Person to join a game
        //MainMenu.printMenu();

        //In Case Player Chose to play a  Game Starter should start
        GameStarter gameStarter = new GameStarter();
        gameStarter.gameInit();

        GameFrame gameFrame = new GameFrame();
        gameFrame.draw();
    }

    private void commandParser() {

    }


    public void drawState(){
        gameFrame.draw();

    }
}
