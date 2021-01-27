package com.escuela.api.controllers;

import com.escuela.api.db.models.*;
import com.escuela.api.jpa.repositories.*;
import com.escuela.api.service.interfaces.JobDetailsService;
import com.escuela.api.service.interfaces.UserService;
import com.escuela.api.service.interfaces.UserSkillMappingService;
import com.escuela.api.service.interfaces.UserTechSkillsService;
import com.escuela.api.ui.models.UserLogin;
import com.escuela.api.service.interfaces.UserService;
import com.escuela.api.ui.models.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/register")
public class UserController { 

    @Autowired
    UserSkillMappingService userSkillMappingService;

    @Autowired
    UserService userService;

    @Autowired
    JobDetailsService jobDetailsService;

    @Autowired
    UserTechSkillsService userTechSkillsService;

    @GetMapping("/finduser")
    public UserWrapper findRegisteredUsers(HttpServletRequest httpServletRequest){
        String email =httpServletRequest.getParameter("email");
        return userService.fetchUserProfile(email);
    }

    @GetMapping("/findalljobs")
    public List<JobDetails> getAllJobs(){
        return jobDetailsService.getAllJobs();
    }

    @GetMapping("/findallskills")
    public List<UserSkills> getAllSkills(){
        return userTechSkillsService.getAllSkills();
    }

    @PostMapping("/addskills")
    public UserSkills newSkill(@RequestBody UserSkills newSkill) {
        return userTechSkillsService.newSkill(newSkill);
    }

    @PostMapping("/addjobs")
    public JobDetails newJob(@RequestBody JobDetails newJob){
        return jobDetailsService.newJob(newJob);
    }

    @PostMapping("/adduserprofile")
    public String addUserDetails(@RequestBody UserWrapper userWrapper){
        return userService.createUserProfile(userWrapper);
    }
    @PostMapping("/sociallogin")
    public UserLogin userSocialLogin(@RequestBody UserLogin userlogin){
       return userService.userSocialLogin(userlogin);
    }

}


