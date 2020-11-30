package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.VideoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDetailsRepository extends JpaRepository<VideoDetails, Integer> {

    @Query("SELECT v FROM VideoDetails v WHERE v.category=?1")
    List<VideoDetails> findByCategory(String category);

}
