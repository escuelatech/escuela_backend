package com.escuela.api.controllers;

import com.escuela.api.db.models.User;
import com.escuela.api.jpa.repositories.UserRepository;
import com.escuela.api.jpa.repositories.UserTechSkillsRepository;
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
    UserRepository registrationRepository;

    @Autowired
    UserTechSkillsRepository userTechSkillsRepository;

    @GetMapping("/findall")
    public List<User> getAllRegisteredUsers(){
        return registrationRepository.findAll();
    }

    @PostMapping("/adduser")
    public User newUser(@RequestBody User newUser){
        return registrationRepository.save(newUser);
    }

    @GetMapping("/finduser")
    public UserWrapper findRegisteredUsers(HttpServletRequest httpServletRequest){

        String email =httpServletRequest.getParameter("email");
        User user=registrationRepository.findUserByEmailID(email);

        UserWrapper userWrapper=new UserWrapper();
        userWrapper.setUser(user);

        List<String> skillIds=new ArrayList<String>();
        user.getSkillMapping().forEach(skillId -> skillIds.add(skillId.getSkillId()));
        userWrapper.setSkills(userTechSkillsRepository.findSkillsByIDs(skillIds));

        return userWrapper;
    }
}


