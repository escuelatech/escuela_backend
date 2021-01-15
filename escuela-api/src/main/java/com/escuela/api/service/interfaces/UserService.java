package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.User;
import com.escuela.api.ui.models.UserWrapper;

import java.util.List;

public interface UserService {

    public List<User> getAllRegisteredUsers();

    public User newUser(User newUser);

    public void saveResume(byte[] resume,String email);

    public User findUser(String email);

    public User createUserProfile(UserWrapper userWrapper);

    public UserWrapper fetchUserProfile(String email);
}
