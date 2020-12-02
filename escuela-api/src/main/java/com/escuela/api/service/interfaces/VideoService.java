package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.VideoDetails;

import java.util.List;

public interface VideoService {
    public List<VideoDetails> getAllVideos();
}
