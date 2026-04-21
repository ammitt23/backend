package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Skill;
import com.skillgappro.backend.repository.SkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")

public class SkillController {

    private final SkillRepository repo;

    public SkillController(SkillRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Skill> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return repo.save(skill);
    }
}