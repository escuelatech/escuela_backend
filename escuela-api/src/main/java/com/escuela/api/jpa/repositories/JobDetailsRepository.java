package com.escuela.api.jpa.repositories;

import com.escuela.api.db.models.JobDetails;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;


@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer> {

    @Query("SELECT jobs FROM JobDetails jobs WHERE jobs.jobId IN (:jobIds)")
    List<JobDetails> findJobsByIDs(@Param("jobIds") List<String> jobIds);

    @Query("SELECT jobs FROM JobDetails jobs WHERE jobs.userId =?1")
    List<JobDetails> findUserJobsByID(Integer userId);
}
