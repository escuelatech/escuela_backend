package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.UserProfile;

import java.util.List;

public interface UserProfileService {
    public UserProfile userDetails(UserProfile userProfile);
    public List<UserProfile> getAllUserDetails();
}
