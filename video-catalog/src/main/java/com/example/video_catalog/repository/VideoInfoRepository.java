package com.example.video_catalog.repository;

import com.example.video_catalog.model.VideoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoInfoRepository extends JpaRepository<VideoInfo, Long> {
}
