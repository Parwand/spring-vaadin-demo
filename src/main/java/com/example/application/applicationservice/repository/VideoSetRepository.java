package com.example.application.applicationservice.repository;

import com.example.application.domain.model.VideoSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mweiss on 15.05.17.
 */
@Repository
public interface VideoSetRepository extends JpaRepository<VideoSet, Long> {
    List<VideoSet> findByFilenameStartsWithIgnoreCase(String filename);

	List<VideoSet> findByTitleLikeIgnoreCaseOrFilenameLikeIgnoreCase(String likeFilterTitle, String likeFilterFilename);
}
