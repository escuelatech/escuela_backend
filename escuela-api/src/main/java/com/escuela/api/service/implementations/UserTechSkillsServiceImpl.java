package com.escuela.api.service.implementations;

import com.escuela.api.db.models.User;
import com.escuela.api.db.models.UserSkills;
import com.escuela.api.jpa.repositories.UserTechSkillsRepository;
import com.escuela.api.service.interfaces.UserTechSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "usertechskillsservice")
public class UserTechSkillsServiceImpl implements UserTechSkillsService {

    @Autowired
    UserTechSkillsRepository userTechSkillsRepository;

    @Override
    public List<UserSkills> findSkillsByIDs(List<String> skillIds) {
        return userTechSkillsRepository.findSkillsByIDs(skillIds);
    }

    @Override
    public List<UserSkills> getAllSkills() {
        return userTechSkillsRepository.findAll();
    }

    public UserSkills newSkill(UserSkills skill){
        return userTechSkillsRepository.save(skill);
    }

}
