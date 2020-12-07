package com.escuela.api.service.implementations;

import com.escuela.api.db.models.UserProfile;
import com.escuela.api.jpa.repositories.UserProfileRepository;
import com.escuela.api.service.interfaces.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userprofileservice")
public class UserProfileServiceImpl implements UserProfileService {

    final
    UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile userDetails(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAllUserDetails(){
        return userProfileRepository.findAll();
    }
}
