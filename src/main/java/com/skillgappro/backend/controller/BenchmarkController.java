package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Benchmark;
import com.skillgappro.backend.service.BenchmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benchmarks")

public class BenchmarkController {

    private final BenchmarkService service;

    public BenchmarkController(BenchmarkService service) {
        this.service = service;
    }

    @GetMapping
    public List<Benchmark> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Benchmark create(@RequestBody Benchmark benchmark) {
        return service.save(benchmark);
    }
}