package org.ta.jcluedo.model.utils.fio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * This Class Controls operation to Files
 */
public class FileWriter {

    public synchronized static void writeTextTOEnd(String address, String text) throws IOException {
        Files.write(Paths.get(address), text.getBytes(), StandardOpenOption.APPEND);
    }

}
