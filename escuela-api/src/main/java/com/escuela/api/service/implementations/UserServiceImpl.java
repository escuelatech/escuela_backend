package com.escuela.api.service.implementations;

import com.escuela.api.db.models.JobDetails;
import com.escuela.api.db.models.User;
import com.escuela.api.db.models.UserSkillMapping;
import com.escuela.api.db.models.UserSkills;
import com.escuela.api.jpa.repositories.JobDetailsRepository;
import com.escuela.api.jpa.repositories.UserRepository;
import com.escuela.api.jpa.repositories.UserSkillMappingRepository;
import com.escuela.api.jpa.repositories.UserTechSkillsRepository;
import com.escuela.api.service.interfaces.UserService;
import com.escuela.api.ui.models.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service(value = "userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSkillMappingRepository userSkillMappingRepository;

    @Autowired
    JobDetailsRepository jobDetailsRepository;

    @Autowired
    UserTechSkillsRepository userTechSkillsRepository;

    public List<User> getAllRegisteredUsers(){
        return userRepository.findAll();
    }

    public User newUser(User newUser){
        return userRepository.save(newUser);
    }

    /**
     *
     * @param resume
     * @param email
     */
    public void saveResume(byte[] resume,String email){
        User user=userRepository.findUserByEmailID(email);//Read user-by userid/user email
        user.setResume(resume);
        //@TODO
        //Find the user from database by email-ID
        //Set the resume to user object and save the user back to database
        userRepository.save(user);
    }

    @Override
    public User findUser(String email) {
        return null;
    }

    @Override
    public User createUserProfile(UserWrapper userWrapper) {

        userRepository.save(userWrapper.getUser());
        User user=userRepository.findUserByEmailID(userWrapper.getUser().getEmail());

        for (UserSkills skill:userWrapper.getSkills()){
            UserSkillMapping skillMapping=new UserSkillMapping();
            skillMapping.setRegistration(user);
            skillMapping.setSkillId(skill.getSkillId());
            userSkillMappingRepository.save(skillMapping);
        }

        for (JobDetails job:userWrapper.getPrevJobs()){
            job.setUserId(user.getUserId());
            jobDetailsRepository.save(job);
        }
        return null;
    }

    @Override
    public UserWrapper fetchUserProfile(String email) {

        //Fetch user from DB
        User user=userRepository.findUserByEmailID(email);
        UserWrapper userWrapper=new UserWrapper();
        userWrapper.setUser(user);

        //Fetch user skills from DB
        List<String> skillIds=new ArrayList<String>();
        user.getSkillMapping().forEach(skillId -> skillIds.add(skillId.getSkillId()));
        userWrapper.setSkills(userTechSkillsRepository.findSkillsByIDs(skillIds));

        //Fetch user Jobs
        userWrapper.setPrevJobs(jobDetailsRepository.findUserJobsByID(user.getUserId()));
        return userWrapper;
    }
}
