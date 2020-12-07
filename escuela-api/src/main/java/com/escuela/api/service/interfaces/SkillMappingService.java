package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.Registration;
import com.escuela.api.db.models.SkillMapping;
import com.escuela.api.db.models.Skills;

import java.util.List;

public interface SkillMappingService {

    List<SkillMapping> findByUser(Registration user, Skills skill);
}
