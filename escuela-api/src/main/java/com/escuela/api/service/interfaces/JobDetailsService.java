package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.JobDetails;

import java.util.List;

public interface JobDetailsService {

    public List<JobDetails> findUserJobsByID(Integer userId);

    public List<JobDetails> getAllJobs();

    public JobDetails newJob(JobDetails job);
}
