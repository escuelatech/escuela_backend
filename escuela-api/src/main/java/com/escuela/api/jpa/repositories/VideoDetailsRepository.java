package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.VideoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoDetailsRepository extends JpaRepository<VideoDetails, Integer> {
}
