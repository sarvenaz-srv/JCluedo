package org.ta.jcluedo.view.menu;

import org.ta.jcluedo.model.utils.SharedData;
import org.ta.jcluedo.model.utils.logger.LogLevels;
import org.ta.jcluedo.model.utils.logger.LoggingManager;

public class MainMenu {

    private static final LoggingManager logger = new LoggingManager(MainMenu.class.getName());

    public static void printMenu() {
        logger.log("starting to print MainMenu", LogLevels.INFO);
        char escCode = SharedData.getInstance().ESC_CODE;
        System.out.printf("%c[37m%c[%dm", escCode, escCode, 43, 1);


    }

}
