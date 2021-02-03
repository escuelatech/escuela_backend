package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.CourseTraining;

import java.util.List;

public interface CourseTrainingService {
    public List<CourseTraining> getAllUserTrainees();

    public String createUserTraineeProfile(CourseTraining training);
}
