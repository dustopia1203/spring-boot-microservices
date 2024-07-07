package com.example.video_catalog.service;

import com.example.video_catalog.model.VideoInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoInfoService {

    VideoInfo saveVideoInfo(VideoInfo videoInfo);

    List<VideoInfo> saveAllVideoInfo(List<VideoInfo> listVideoInfo);

    List<VideoInfo> getAllVideoInfo();

    VideoInfo getVideoInfoById(Long id);
}
