package com.github.hdghg.edgecenterrucdnmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class EdgecenterrucdnmockApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdgecenterrucdnmockApplication.class, args);
    }

    private Random random = new Random();

    @PostMapping("/streaming/videos")
    public Map<?, ?> streamingVideos() {
        return Collections.singletonMap("id", random.nextInt());
    }

    @GetMapping("/streaming/videos/{id}/upload")
    public Map<?, ?> videoUpload(@PathVariable("id") Long id) {
        Map<String, Object> video = new HashMap<>();
        video.put("clientId", "");
        video.put("id", "" + id);
        video.put("hls_url", "E");

        Map<String, Object> response = new HashMap<>();
        response.put("video", video);
        response.put("token", "");
        response.put("servers", Collections.singletonList(Collections.singletonMap("hostname", "cdnmock")));
        return response;
    }

    @GetMapping("/streaming/videos/{id}/")
    public Map<?, ?> video(@PathVariable("id") Long id, @RequestParam("download") Boolean download) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("status", "ready");
        return result;
    }

}
