package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.EscuelaServiceContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscuelaServiceContentRepository extends JpaRepository<EscuelaServiceContent, Integer> {

    @Query("SELECT e FROM EscuelaServiceContent e WHERE e.id=?1")
    List<EscuelaServiceContent> findContentById(Integer id);
}
