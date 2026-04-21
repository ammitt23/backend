package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.JobPost;
import com.skillgappro.backend.repository.JobPostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobposts")

public class JobPostController {

    private final JobPostRepository repo;

    public JobPostController(JobPostRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<JobPost> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public JobPost create(@RequestBody JobPost job) {
        return repo.save(job);
    }
}
