package com.escuela.api.ui.models;

import com.escuela.api.db.models.JobDetails;
import com.escuela.api.db.models.User;
import com.escuela.api.db.models.UserSkills;

import java.util.List;

public class UserWrapper {

    private User user;
    private List<UserSkills> skills;
    private List<JobDetails> prevJobs;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserSkills> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkills> skills) {
        this.skills = skills;
    }

    public List<JobDetails> getPrevJobs() {
        return prevJobs;
    }

    public void setPrevJobs(List<JobDetails> prevJobs) {
        this.prevJobs = prevJobs;
    }
}
