package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.UserSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillsRepository extends JpaRepository<UserSkills, Integer> {
}
