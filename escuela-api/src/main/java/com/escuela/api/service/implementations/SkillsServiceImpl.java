package com.escuela.api.service.implementations;

import com.escuela.api.db.models.Skills;
import com.escuela.api.jpa.repositories.SkillsRepository;
import com.escuela.api.service.interfaces.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="skillsservice")
public class SkillsServiceImpl implements SkillsService {

    final
    SkillsRepository skillsRepository;

    public SkillsServiceImpl(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public Skills submitSkills(Skills newSkills){
        return skillsRepository.save(newSkills);
    }

    public List<Skills> getSkills(){
        return skillsRepository.findAll();
    }
}
