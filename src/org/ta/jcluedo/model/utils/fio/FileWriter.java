package org.ta.jcluedo.model.utils.fio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * This Class Controls operation to Files
 */
public class FileWriter {

    public synchronized static void writeTextTOEnd(String address, String fileName, String text) throws IOException {
        if (!Files.exists(Paths.get(address)))
            Paths.get(address).toFile().mkdirs();

        if (!Files.exists(Paths.get(address + fileName))) {
            File file = new File(address + fileName);
            file.createNewFile();
        }
        Files.write(Paths.get(address + fileName), text.getBytes(), StandardOpenOption.APPEND);
    }

}
