package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.UserSkills;
import com.escuela.api.ui.models.TechSkills;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTechSkillsService {

    List<UserSkills> findSkillsByIDs(List<String> skillIds);

    List<TechSkills> getAllSkills();

    public UserSkills newSkill(UserSkills skill);
}
