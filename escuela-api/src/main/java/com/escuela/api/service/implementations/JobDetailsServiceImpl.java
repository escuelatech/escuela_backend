package com.escuela.api.service.implementations;

import com.escuela.api.db.models.JobDetails;
import com.escuela.api.db.models.User;
import com.escuela.api.jpa.repositories.JobDetailsRepository;
import com.escuela.api.service.interfaces.JobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "jobdetailsservice")
public class JobDetailsServiceImpl implements JobDetailsService {

    @Autowired
    JobDetailsRepository jobDetailsRepository;

    @Override
    public List<JobDetails> findUserJobsByID(Integer userId) {
        return jobDetailsRepository.findUserJobsByID(userId);
    }

    @Override
    public List<JobDetails> getAllJobs() {
        return jobDetailsRepository.findAll();
    }


    public JobDetails newJob(JobDetails job){
        return jobDetailsRepository.save(job);
    }
}
