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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/findall")
    public List<User> getAllRegisteredUsers(){
//        return userRepository.findAll();
        return userService.getAllRegisteredUsers();
    }

    @PostMapping("/adduser")
    public User newUser(@RequestBody User newUser){
//        return userRepository.save(newUser);
        return userService.newUser(newUser);
    }

    @GetMapping("/finduser")
    public UserWrapper findRegisteredUsers(HttpServletRequest httpServletRequest){
        String email =httpServletRequest.getParameter("email");
        
        //Fetch user from DB
        Optional<User> dbUser=userService.findUserByEmailID(email);
        UserWrapper userWrapper=new UserWrapper();
        User user=dbUser.get();
        userWrapper.setUser(user);

        //Fetch user skills from DB
        List<String> skillIds=new ArrayList<String>();
        user.getSkillMapping().forEach(skillId -> skillIds.add(skillId.getSkillId()));
        userWrapper.setSkills(userTechSkillsService.findSkillsByIDs(skillIds));

        //Fetch user Jobs
        userWrapper.setPrevJobs(jobDetailsService.findUserJobsByID(user.getUserId()));
        return userWrapper;
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
      
        //userRepository.save(userWrapper.getUser());
        User userProfileInfo=userWrapper.getUser();
        Optional<User> dbUser=userService.findUserByEmailID(userProfileInfo.getEmail());

        User user=dbUser.get();

        user.setCity(userProfileInfo.getCity());
        user.setPhone(userProfileInfo.getPhone());
        user.setCollegeLocation(userProfileInfo.getCollegeLocation());
        user.setCollegeName(userProfileInfo.getCollegeName());
        user.setFieldOfStudy(userProfileInfo.getFieldOfStudy());
        user.setHighestDegree(userProfileInfo.getHighestDegree());

        for (UserSkills skill:userWrapper.getSkills()){
             UserSkillMapping skillMapping=new UserSkillMapping();
             skillMapping.setRegistration(dbUser.get());
             skillMapping.setSkillId(skill.getSkillId());
//           skillMapping.setSkillId("111");
             userSkillMappingService.newUserSkill(skillMapping);
        }

        for (JobDetails job:userWrapper.getPrevJobs()){
            job.setUserId(dbUser.get().getUserId());
            jobDetailsService.newJob(job);
        }

        user.setProfileStatus("complete");
        //save the user info.
        userService.newUser(user);


        return "user profile updated";
    }

    @PostMapping("/sociallogin")
    public UserLogin userSocialLogin(@RequestBody UserLogin userlogin){
        //find user with the email.
        Optional<User> dbUser=userService.findUserByEmailID(userlogin.getEmail());
        if(!dbUser.isPresent()){
            //If user not found persist the user to DB
            User user=new User();
            user.setFirstName(userlogin.getFirstName());
            user.setLastName(userlogin.getLastName());
            user.setEmail(userlogin.getEmail());
            user.setProfileStatus("incomplete");
            userService.newUser(user);
        }
        return userlogin;
    }

}


