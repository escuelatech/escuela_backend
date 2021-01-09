package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.UserSkillMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillMappingRepository extends JpaRepository<UserSkillMapping,Integer>{
}
