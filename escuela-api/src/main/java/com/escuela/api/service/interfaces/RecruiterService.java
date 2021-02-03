package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.Recruiter;
import com.escuela.api.ui.models.RecruiterWrapper;

import java.util.List;

public interface RecruiterService {

    public List<Recruiter> getAllRegisteredRecruiters();

    public String createRecruiterProfile(Recruiter recruiter);

}
