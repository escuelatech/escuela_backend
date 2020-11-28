package com.escuela.api.controllers;

import com.escuela.api.db.models.Registration;
import com.escuela.api.jpa.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/register")
public class RegistrationController {

    @Autowired
    RegistrationRepository registrationRepository;

    public List<Registration> getAllRegisteredUsers(){
        return registrationRepository.findAll();
    }
}
