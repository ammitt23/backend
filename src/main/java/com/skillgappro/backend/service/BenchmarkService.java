
package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.Benchmark;
import com.skillgappro.backend.repository.BenchmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchmarkService {

    private final BenchmarkRepository repo;

    public BenchmarkService(BenchmarkRepository repo) {
        this.repo = repo;
    }

    public List<Benchmark> getAll() {
        return repo.findAll();
    }

    public Benchmark save(Benchmark benchmark) {
        return repo.save(benchmark);
    }
}