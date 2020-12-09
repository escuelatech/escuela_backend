package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   @Query("SELECT R FROM User R WHERE R.email=?1")
   User findUserByEmailID(String email);

}

