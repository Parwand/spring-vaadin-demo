package com.example.application.applicationservice.service;


import com.example.application.domain.model.VideoSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    private final VideoTranscodeService videoTranscodeService;

    public AsyncService(VideoTranscodeService videoTranscodeService) {
        this.videoTranscodeService = videoTranscodeService;
    }

    @Async
    public Boolean execute(File input, VideoSet video, VideoSetService videoSetService) {
        long start = System.currentTimeMillis();
        try {
            CompletableFuture<File> videoHigh = videoTranscodeService.execute(input, VideoTranscodeService.Quality.HIGH);
            CompletableFuture<File> videoMedium = videoTranscodeService.execute(input, VideoTranscodeService.Quality.MEDIUM);
            CompletableFuture<File> videoLow = videoTranscodeService.execute(input, VideoTranscodeService.Quality.LOW);

            CompletableFuture.allOf(videoHigh, videoMedium, videoLow).join();

            // delete the original file to prevent the transcoding server disk from becoming full
            //input.delete();

            log.info("Elapsed time: " + ((System.currentTimeMillis() - start) / 1000.000) + " seconds");
            log.info("--> " + videoHigh.get());
            log.info("--> " + videoMedium.get());
            log.info("--> " + videoLow.get());

            video.setTranscoded(true);
            videoSetService.createVideoSet(video);

        } catch(Exception e) {
            log.error("video transcoding error", e);
            return false;
        }
        return true;
    }

}