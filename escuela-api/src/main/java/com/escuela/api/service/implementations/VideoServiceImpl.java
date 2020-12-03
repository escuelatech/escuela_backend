package com.escuela.api.service.implementations;

import com.escuela.api.db.models.VideoDetails;
import com.escuela.api.jpa.repositories.VideoDetailsRepository;
import com.escuela.api.service.interfaces.VideoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "videoservice")
public class VideoServiceImpl implements VideoService{


    private static native void registerNatives();

    final VideoDetailsRepository videoDetailsRepository;

    public VideoServiceImpl(VideoDetailsRepository videoDetailsRepository) {
        this.videoDetailsRepository = videoDetailsRepository;
    }

    @Override
    public List<VideoDetails> getAllVideos() {
        return videoDetailsRepository.findAll();
    }

    @Override
    public List<VideoDetails> getVideosByCategory(String category){
        return videoDetailsRepository.findByCategory(category);
    }

    @Override
    public VideoDetails addNewVideo(VideoDetails video){
        return videoDetailsRepository.save(video);
    }

}
