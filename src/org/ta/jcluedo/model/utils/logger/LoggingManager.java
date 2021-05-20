package org.ta.jcluedo.model.utils.logger;

import org.ta.jcluedo.model.utils.fio.FileWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingManager {

    private final String ROOT_DIR = "./log/";
    private final String LOG_FILE = "log.txt";
    private final String ERROR_FILE = "./log/error/";
    private final String CLASS_NAME;

    public LoggingManager(String CLASS_NAME) {
        this.CLASS_NAME = CLASS_NAME;
    }

    /**
     * using {@link #logPattern(String, String)}
     *
     * @param msg   of log
     * @param level of log (WARN,INFO,ERROR ,...)
     */
    public void log(String msg, LogLevels level) {
        try {
            FileWriter.writeTextTOEnd(ROOT_DIR, LOG_FILE, logPattern(msg, level.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Make The Log using special Patern
     *
     * @param level
     * @param msg
     * @return
     */
    private String logPattern(String msg, String level) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String result = formatter.format(date) + " [" + level + "] " + CLASS_NAME
                + " ---> " + msg + "\n";
        return result;
    }

}
