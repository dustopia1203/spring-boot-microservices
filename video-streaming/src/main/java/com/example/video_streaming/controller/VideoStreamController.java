package com.example.video_streaming.controller;

import com.example.video_streaming.service.VideoCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/v1/stream")
@RequiredArgsConstructor
public class VideoStreamController {

    @Value("${video.directory.path}")
    private String VIDEO_DIRECTORY;

    private final VideoCatalogService videoCatalogService;

    @GetMapping("/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(
            @PathVariable String videoPath
    ) throws FileNotFoundException {
        File file = new File(VIDEO_DIRECTORY + videoPath);
        if (file.exists()) {
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(inputStreamResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/id/{videoId}")
    public ResponseEntity<InputStreamResource> streamVideoWithId(
            @PathVariable Long videoId
    ) throws FileNotFoundException {
        String videoPath = videoCatalogService.getVideoPath(videoId);
        return streamVideo(videoPath);
    }

}
