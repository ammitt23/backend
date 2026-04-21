
package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.Benchmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchmarkRepository extends JpaRepository<Benchmark, Long> {
}