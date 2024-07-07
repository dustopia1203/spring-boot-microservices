package com.example.video_catalog.controller;

import com.example.video_catalog.model.VideoInfo;
import com.example.video_catalog.service.VideoInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/video-info")
@RequiredArgsConstructor
public class VideoInfoController {

    private final VideoInfoService videoInfoService;

    @PostMapping("")
    public ResponseEntity<VideoInfo> saveVideoInfo(
            @RequestBody VideoInfo videoInfo
    ) {
        VideoInfo savedVideoInfo = videoInfoService.saveVideoInfo(videoInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVideoInfo);
    }

    @PostMapping("/list")
    public ResponseEntity<List<VideoInfo>> saveAllVideoInfo(
            @RequestBody List<VideoInfo> listVideoInfo
    ) {
        List<VideoInfo> savedListVideoInfo = videoInfoService.saveAllVideoInfo(listVideoInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedListVideoInfo);
    }

    @GetMapping("")
    public ResponseEntity<List<VideoInfo>> getAllVideoInfo() {
        List<VideoInfo> listVideoInfo = videoInfoService.getAllVideoInfo();
        return ResponseEntity.status(HttpStatus.OK).body(listVideoInfo);
    }

    @GetMapping("/path/{id}")
    public ResponseEntity<String> getVideoInfoById(
            @PathVariable Long id
    ) {
        VideoInfo videoInfo = videoInfoService.getVideoInfoById(id);
        String path = videoInfo.getPath();
        return ResponseEntity.status(HttpStatus.OK).body(path);
    }

}
