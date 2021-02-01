package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.Recruiter;
import com.escuela.api.db.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Integer> {

   @Query("SELECT R FROM Recruiter R WHERE R.email=?1")
   Optional<Recruiter> findUserByEmailID(String email);

}

