package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.JobRole;
import com.skillgappro.backend.repository.JobRoleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobroles")

public class JobRoleController {

    private final JobRoleRepository repo;

    public JobRoleController(JobRoleRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<JobRole> getAll() {
        return repo.findAll();
    }
}