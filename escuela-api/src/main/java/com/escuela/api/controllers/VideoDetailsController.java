package com.escuela.api.controllers;

import com.escuela.api.db.models.VideoDetails;
import com.escuela.api.jpa.repositories.VideoDetailsRepository;
import com.escuela.api.service.interfaces.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/video")
public class VideoDetailsController {

    @Autowired
    VideoService videoService;

    @GetMapping("/getallvideos")
    public List<VideoDetails> getAllVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("/getvideosbycategory/{category}")
    public List<VideoDetails> getVideosByCategory(@PathVariable String category){
        return videoService.getVideosByCategory(category);
    }

    @PostMapping("/addvideo")
    public VideoDetails addNewVideo(@RequestBody VideoDetails video){
        return videoService.addNewVideo(video);
    }

    


}
