package com.epam.spring.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksandr_Kokhanyuk on 7/26/2016.
 */
public class FileEventLogger implements EventLogger {
    public FileEventLogger(String filename) {
        this.fileName = filename;
    }

    private String fileName;
    private File file;

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(file, event.toString(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init() throws IOException{
        this.file=new File(fileName);
        file.canWrite();
    }
}
