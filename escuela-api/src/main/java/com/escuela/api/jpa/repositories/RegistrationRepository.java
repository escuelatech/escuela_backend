package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.Registration;
import com.escuela.api.db.models.VideoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {

   @Query("SELECT R FROM Registration R WHERE R.email=?1")
   List<Registration> findUserByEmailID(String email);

  // @Query()
  // List<Registration> updateUserEmail(@Param("email") String email);

}

