package com.example.video_streaming.service.impl;

import com.example.video_streaming.service.VideoCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class VideoCatalogServiceImpl implements VideoCatalogService {

    @Value("${video-catalog-service.url}")
    private String CATALOG_SERVICE;

    private final RestTemplate restTemplate;

    @Override
    public String getVideoPath(Long videoInfoId) {
        ResponseEntity<String> response = restTemplate.getForEntity(CATALOG_SERVICE + "/api/v1/video-info/path/{videoId}", String.class, videoInfoId);
        return response.getBody();
    }
}
