package com.escuela.api.controllers;

import com.escuela.api.db.models.Registration;
import com.escuela.api.jpa.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
