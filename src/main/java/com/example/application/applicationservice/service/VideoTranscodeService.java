package com.example.application.applicationservice.service;

import com.example.application.applicationservice.util.ProcessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.concurrent.CompletableFuture;

@Service
public class VideoTranscodeService {

    private static final Logger log = LoggerFactory.getLogger(VideoTranscodeService.class);


    public enum Quality {
        HIGH("high"), MEDIUM("medium"), LOW("low");

        private String level;

        Quality(String level) {
            this.level = level;
        }

        public String getLevel() {
            return this.level;
        }
    }

    @Value("${handbrakecli.presets.path}")
    private String presetsPath;

    @Value("${handbrakecli.cpulimit.percentage}")
    private String cpulimitPercentage;

    @Async
    public CompletableFuture<File> execute(File input, Quality quality) throws InterruptedException, IOException {
        String executableName = "HandBrakeCLI";
        String outputPath = input.getPath().replaceAll("original", quality.getLevel());
        File output = new File(outputPath);

        String preset = "video_h264_" + quality.getLevel();
        String preset_import_file = presetsPath + preset + ".json";

        ProcessBuilder builder = new ProcessBuilder(executableName,
                "--input", input.getPath(),
                "--output", output.getPath(),
                "--preset-import-file", preset_import_file,
                "--preset", preset);
        builder.redirectErrorStream(true);

        log.info("Executing: " + builder.command().toString());

        final Process process = builder.start();

        // cpulimit support only works on UNIX systems and this fragment
        // is a potential cause of errors if the process is finished before cpulimit has started
        long pid = ProcessHandler.getPidOfUNIXProcess(process);
        if(pid != -1) {
            ProcessBuilder pb = new ProcessBuilder("cpulimit",
                    "-p", Long.toString(pid),
                    "-l", cpulimitPercentage);
            pb.redirectErrorStream(true);
            log.info("Executing: " + pb.command().toString());
            final Process p = pb.start();

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Encode done")) {
                    log.info(quality.getLevel() + ": " + line);
                } else {
                    log.debug(Thread.currentThread() + ": " + line);
                }
            }
            p.waitFor();
        }
        process.waitFor();
        log.info("Handbrake exited with code: " + process.exitValue());
        return CompletableFuture.completedFuture(output);
    }
}
