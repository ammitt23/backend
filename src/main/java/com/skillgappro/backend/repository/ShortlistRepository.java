package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.Shortlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShortlistRepository extends JpaRepository<Shortlist, Long> {

    
    // 🔥 REQUIRED for employer dashboard
    List<Shortlist> findByEmployerId(Long employerId);
}