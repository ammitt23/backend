package com.skillgappro.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")

public class JobController {

    // 👉 TEMP (replace with service later)
    @GetMapping("/employer/{id}")
    public List<String> getEmployerJobs(@PathVariable Long id) {
        return List.of("Job 1", "Job 2", "Job 3");
    }
}