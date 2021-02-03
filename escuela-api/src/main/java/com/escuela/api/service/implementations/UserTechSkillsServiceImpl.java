package com.escuela.api.service.implementations;

import com.escuela.api.db.models.UserSkills;
import com.escuela.api.jpa.repositories.UserTechSkillsRepository;
import com.escuela.api.service.interfaces.UserTechSkillsService;
import com.escuela.api.ui.models.TechSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<TechSkills> getAllSkills() {
        List<TechSkills> techSkillsList = new ArrayList<>();
        for(UserSkills skill: userTechSkillsRepository.findAll()) {
            TechSkills techSkills = new TechSkills();
            techSkills.setId(skill.getSkillId());
            techSkills.setLabel(skill.getLabel());
            techSkills.setValue(skill.getSkillName());
            techSkillsList.add(techSkills);

        }

        return techSkillsList;
    }

    public UserSkills newSkill(UserSkills skill){
        return userTechSkillsRepository.save(skill);
    }

}
