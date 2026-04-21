package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    List<JobPost> findByIsActiveTrue();
}