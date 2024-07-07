package com.example.video_streaming.service;

import org.springframework.stereotype.Service;

@Service
public interface VideoCatalogService {

    String getVideoPath(Long videoInfoId);

}
