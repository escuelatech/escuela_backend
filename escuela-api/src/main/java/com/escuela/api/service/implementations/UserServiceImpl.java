package com.escuela.api.service.implementations;

import com.escuela.api.db.models.User;
import com.escuela.api.jpa.repositories.UserRepository;
import com.escuela.api.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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
        //User user=userRepository.findUserByEmailID(email);//Read user-by userid/user email
        Optional<User> dbUser=userRepository.findUserByEmailID(email);
        if(dbUser.isPresent()) {
            User user=dbUser.get();
            user.setResume(resume);
            userRepository.save(user);
        }
    }

    @Override
    public Optional<User> findUserByEmailID(String email) {
        return userRepository.findUserByEmailID(email);
    }
}
