package com.example.application.applicationservice.service;

import com.example.application.applicationservice.repository.VideoSetRepository;
import com.example.application.domain.model.VideoSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.util.List;

@Service
@Transactional
public class VideoSetService {

    private final static Logger log = LoggerFactory.getLogger(VideoSetService.class);

    private final VideoSetRepository videoSetRepository;

    @Value("${video.path.external}")
    private String videoPathExternal;

    @Value("${video.path.internal}")
    private String videoPathInternal;

    public VideoSetService(VideoSetRepository videoSetRepository) {
        this.videoSetRepository = videoSetRepository;
    }

    public VideoSet createVideoSet(VideoSet videoSet) {

        videoSet.setDeleted(false);

        return videoSetRepository.save(videoSet);
    }
    public void delete(final VideoSet videoSet) {
        Assert.notNull(videoSet);

        String foldername;

        if (videoSet.isIsExternal()) {
            foldername = videoPathExternal + videoSet.getTitle();
        } else {
            foldername = videoPathInternal + videoSet.getTitle();
        }

        File folder = new File(foldername);
        if (folder.exists()) {
            if (!FileSystemUtils.deleteRecursively(folder)) {
                log.error("Problem occurs when deleting the directory : " + folder);
            }
        }

        videoSet.setDeleted(true);
        videoSetRepository.save(videoSet);
    }

    public List<VideoSet> findAll() {
        return videoSetRepository.findAll();
    }

    public List<VideoSet> findByTitleLikeIgnoreCaseOrFilenameLikeIgnoreCase(String likeFilter) {
        return this.videoSetRepository.findByTitleLikeIgnoreCaseOrFilenameLikeIgnoreCase(likeFilter, likeFilter);
    }
}