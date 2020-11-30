package com.escuela.api.controllers;

import com.escuela.api.db.models.VideoDetails;
import com.escuela.api.jpa.repositories.VideoDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoDetailsController {

    @Autowired
    VideoDetailsRepository videoDetailsRepository;

    @GetMapping("/getallvideos")
    public List<VideoDetails> getAllVideos(){
        return videoDetailsRepository.findAll();
    }

    @GetMapping("/getbycategory/{category}")
    public List<VideoDetails> getVideosByCategory(@PathVariable String category){
        return (List<VideoDetails>) videoDetailsRepository.findByCategory(category);
    }

}
