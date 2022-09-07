package com.example.application.applicationservice.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FilenameHandler {

    public static Path generateUniqueFilename(int round, String filename, String videoPath) {
        return generateUniqueFilename(round, filename, null, videoPath);
    }

    public static Path generateUniqueFilename(int round, String newFilename, String oldFilename, String videoPath) {
        StringBuilder uniqueFilename = new StringBuilder();
        uniqueFilename.append(videoPath);
        uniqueFilename.append(newFilename);
        if (round != 0) {
            uniqueFilename.append("_");
            uniqueFilename.append(round);
        }
        uniqueFilename.append("/original.mp4");

        File targetFile = new File(uniqueFilename.toString());
        if (!targetFile.exists()) {
            targetFile.getParentFile().mkdirs();
            return Paths.get(uniqueFilename.toString());
        } else {
            if(oldFilename != null) {
                StringBuilder currentFilename = new StringBuilder();
                currentFilename.append(videoPath);
                currentFilename.append(oldFilename);
                currentFilename.append("/original.mp4");
                if(currentFilename.toString().equals(uniqueFilename.toString())) {
                    return Paths.get(uniqueFilename.toString());
                }
            }
            return generateUniqueFilename(++round, newFilename, oldFilename, videoPath);
        }
    }
}
