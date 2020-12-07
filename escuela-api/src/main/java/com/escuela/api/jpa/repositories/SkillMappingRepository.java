package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.SkillMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillMappingRepository extends JpaRepository<SkillMapping, Integer> {
}
