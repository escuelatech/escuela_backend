package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.UserSkills;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTechSkillsService {

    List<UserSkills> findSkillsByIDs(List<String> skillIds);

    List<UserSkills> getAllSkills();

    public UserSkills newSkill(UserSkills skill);
}
