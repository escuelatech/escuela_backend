package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.UserSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 */
public interface UserTechSkillsRepository extends JpaRepository<UserSkills,Integer> {

    @Query("SELECT skills FROM UserSkills skills WHERE skills.skillId IN (:skillIds)")     // 2. Spring JPA In cause using @Query
    List<UserSkills> findSkillsByIDs(@Param("skillIds") List<String> skillIds);




}
