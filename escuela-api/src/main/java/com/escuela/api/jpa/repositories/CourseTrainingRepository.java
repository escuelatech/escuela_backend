package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.CourseTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseTrainingRepository extends JpaRepository<CourseTraining, Integer> {

    @Query("SELECT c FROM CourseTraining c WHERE c.email=?1")
    Optional<CourseTraining> findUserByEmailID(String email);
}
