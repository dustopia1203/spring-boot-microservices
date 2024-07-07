package com.example.video_catalog.service.impl;

import com.example.video_catalog.model.VideoInfo;
import com.example.video_catalog.repository.VideoInfoRepository;
import com.example.video_catalog.service.VideoInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoInfoServiceImpl implements VideoInfoService {

    private final VideoInfoRepository videoInfoRepository;

    @Override
    public VideoInfo saveVideoInfo(VideoInfo videoInfo) {
        return videoInfoRepository.save(videoInfo);
    }

    @Override
    public List<VideoInfo> saveAllVideoInfo(List<VideoInfo> listVideoInfo) {
        return videoInfoRepository.saveAll(listVideoInfo);
    }

    @Override
    public List<VideoInfo> getAllVideoInfo() {
        return videoInfoRepository.findAll();
    }

    @Override
    public VideoInfo getVideoInfoById(Long id) {
        VideoInfo videoInfo = videoInfoRepository.findById(id).orElse(null);
        if (videoInfo == null) throw new RuntimeException("Video info not found");
        return videoInfo;
    }

}
