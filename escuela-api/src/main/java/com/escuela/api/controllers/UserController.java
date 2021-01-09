package com.escuela.api.controllers;

import com.escuela.api.db.models.*;
import com.escuela.api.jpa.repositories.*;
import com.escuela.api.ui.models.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTechSkillsRepository userTechSkillsRepository;

    @Autowired
    JobDetailsRepository jobDetailsRepository;

    @Autowired
    UserSkillMappingRepository userSkillMappingRepository;


    @GetMapping("/findall")
    public List<User> getAllRegisteredUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/adduser")
    public User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/finduser")
    public UserWrapper findRegisteredUsers(HttpServletRequest httpServletRequest){

        String email =httpServletRequest.getParameter("email");
        
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

    @GetMapping("/findalljobs")
    public List<JobDetails> getAllJobs(){
        return jobDetailsRepository.findAll();
    }

    @GetMapping("/findallskills")
    public List<UserSkills> getAllSkills(){
        return userTechSkillsRepository.findAll();
    }

    @PostMapping("/addskills")
    public UserSkills newSkill(@RequestBody UserSkills newSkill) {
        return userTechSkillsRepository.save(newSkill);
    }

    @PostMapping("/addjobs")
    public JobDetails newJob(@RequestBody JobDetails newJob){
        return jobDetailsRepository.save(newJob);
    }

    @PostMapping("/adduserprofile")
    public String addUserDetails(@RequestBody UserWrapper userWrapper){

        userRepository.save(userWrapper.getUser());
        User user=userRepository.findUserByEmailID(userWrapper.getUser().getEmail());
        for (UserSkills skill:userWrapper.getSkills()){
             UserSkillMapping skillMapping=new UserSkillMapping();
             skillMapping.setRegistration(user);
             skillMapping.setSkillId(skill.getSkillId());
//            skillMapping.setSkillId("111");
             userSkillMappingRepository.save(skillMapping);
        }

        for (JobDetails job:userWrapper.getPrevJobs()){
            job.setUserId(user.getUserId());
            jobDetailsRepository.save(job);
        }
        return "user profile updated";
    }

}


