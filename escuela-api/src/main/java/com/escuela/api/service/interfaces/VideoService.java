package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.VideoDetails;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface VideoService {
    public List<VideoDetails> getAllVideos();

    public List<VideoDetails> getVideosByCategory(String category);

    public VideoDetails addNewVideo(VideoDetails video);
}
