package com.escuela.api.controllers;

import com.escuela.api.db.models.Registration;
import com.escuela.api.jpa.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    RegistrationRepository registrationRepository;

    @GetMapping("/findall")
    public List<Registration> getAllRegisteredUsers(){
        return registrationRepository.findAll();
    }

    @PostMapping("/adduser")
    public Registration newUser(@RequestBody Registration newUser){
        return registrationRepository.save(newUser);
    }

    @GetMapping("/finduser")
    public List<Registration> findRegisteredUsers(HttpServletRequest httpServletRequest){

        String email =httpServletRequest.getParameter("email");

        return registrationRepository.findUserByEmailID(email);
    }
}


