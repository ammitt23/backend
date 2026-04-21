package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.JobPost;
import com.skillgappro.backend.repository.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final JobPostRepository repo;

    public MatchService(JobPostRepository repo) {
        this.repo = repo;
    }

    public List<JobPost> getActiveJobs() {
        return repo.findByIsActiveTrue();
    }
}