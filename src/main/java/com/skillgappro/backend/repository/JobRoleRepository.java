package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
}