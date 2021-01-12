package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    public List<User> getAllRegisteredUsers();

    public User newUser(User newUser);

    public void saveResume(byte[] resume,String email);
}
