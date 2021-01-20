package com.escuela.api.service.implementations;

import com.escuela.api.db.models.User;
import com.escuela.api.db.models.UserSkillMapping;
import com.escuela.api.jpa.repositories.UserSkillMappingRepository;
import com.escuela.api.service.interfaces.UserSkillMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userskillmappingservice")
public class UserSkillMappingServiceImpl implements UserSkillMappingService {

    @Autowired
    UserSkillMappingRepository userSkillMappingRepository;

    public UserSkillMapping newUserSkill(UserSkillMapping newSkill){
        return userSkillMappingRepository.save(newSkill);
    }
}
