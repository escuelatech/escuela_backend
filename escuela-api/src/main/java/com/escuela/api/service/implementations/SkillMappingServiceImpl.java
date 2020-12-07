package com.escuela.api.service.implementations;

import com.escuela.api.db.models.Registration;
import com.escuela.api.db.models.SkillMapping;
import com.escuela.api.db.models.Skills;
import com.escuela.api.jpa.repositories.SkillMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="skillmappingservice")
public class SkillMappingServiceImpl {

    final
    SkillMappingRepository skillMappingRepository;

    public SkillMappingServiceImpl(SkillMappingRepository skillMappingRepository) {
        this.skillMappingRepository = skillMappingRepository;
    }

//    public List<SkillMapping> findByUser(Registration user, Skills skill){
//        return this.skillMappingRepository
//    }
}
