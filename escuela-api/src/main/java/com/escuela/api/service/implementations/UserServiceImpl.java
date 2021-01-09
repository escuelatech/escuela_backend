package com.escuela.api.service.implementations;

import com.escuela.api.db.models.User;
import com.escuela.api.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service(value = "userservice")
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllRegisteredUsers(){
        return userRepository.findAll();
    }

    public User newUser(User newUser){
        return userRepository.save(newUser);
    }
}
