package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.Skills;

import java.util.List;

public interface SkillsService {

    public Skills submitSkills(Skills newSkills);
    public List<Skills> getSkills();
}
