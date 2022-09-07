package com.example.application.applicationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class VideoUploadService {


    private static final Logger log = LoggerFactory.getLogger(VideoUploadService.class);
    private static final long serialVersionUID = -4215347104504527217L;

    private File file;
    private FileOutputStream fop;

    private String filename;
    private String MIMEType;

    public OutputStream receiveUpload(String filename, String MIMEType) {

        this.filename = filename;
        this.MIMEType = MIMEType;

        try {
            if(MIMEType.equalsIgnoreCase("video/mp4")) {
                file = new File("/tmp/uploads/" + filename);

                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                fop = new FileOutputStream(file);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return fop;
    }

    public File getFile() {
        return file;
    }

    public String getFilename() {
        return filename;
    }

    public String getMIMEType() {
        return MIMEType;
    }
}
