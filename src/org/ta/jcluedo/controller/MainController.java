package org.ta.jcluedo.controller;

import org.ta.jcluedo.model.utils.logger.LogLevels;
import org.ta.jcluedo.model.utils.logger.LoggingManager;
import org.ta.jcluedo.view.menu.MainMenu;

/**
 * This is the CLass that Runs at first
 */
public class MainController {

    private static final LoggingManager logger = new LoggingManager(MainController.class.getName());

    /**
     * Show The MainMenu and  get ready to read commands
     */
    public void start() {
        logger.log("Program Starts", LogLevels.INFO); // make log
        MainMenu.printMenu();
    }

    private void commandParser() {

    }

}
