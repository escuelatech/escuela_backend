package com.escuela.api.service.implementations;

import com.escuela.api.db.models.User;
import com.escuela.api.jpa.repositories.UserRepository;
import com.escuela.api.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service(value = "userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

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
}
