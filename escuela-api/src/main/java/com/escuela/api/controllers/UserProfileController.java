package com.escuela.api.controllers;


import com.escuela.api.db.models.Skills;
import com.escuela.api.db.models.UserProfile;
import com.escuela.api.jpa.repositories.SkillsRepository;
import com.escuela.api.service.interfaces.SkillMappingService;
import com.escuela.api.service.interfaces.SkillsService;
import com.escuela.api.service.interfaces.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserProfileController {

    final
    SkillsService skillsService;

    final
    UserProfileService userProfileService;

//    final
//    SkillMappingService skillMappingService;

    public UserProfileController(SkillsService skillsService, UserProfileService userProfileService) {
        this.skillsService = skillsService;
        this.userProfileService = userProfileService;
//        this.skillMappingService = skillMappingService;
    }

    @PostMapping("/skills")
    public Skills submitSkills(Skills newSkills){
        return skillsService.submitSkills(newSkills);
    }

    @GetMapping("/getskills")
    public List<Skills> getAllSkills(){
        return skillsService.getSkills();
    }

    @PostMapping("/userdetails")
    public UserProfile userDetails(@RequestBody UserProfile userProfile){
        return userProfileService.userDetails(userProfile);
    }

    @GetMapping("/getalluserDetails")
    public List<UserProfile> getAllUserDetails(){
        return userProfileService.getAllUserDetails();
    }
}
