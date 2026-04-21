package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Shortlist;
import com.skillgappro.backend.repository.ShortlistRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shortlists")

public class ShortlistController {

    private final ShortlistRepository repo;

    public ShortlistController(ShortlistRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Shortlist> getAll() {
        return repo.findAll();
    }
}