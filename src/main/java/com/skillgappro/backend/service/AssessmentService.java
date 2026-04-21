package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.Assessment;
import com.skillgappro.backend.repository.AssessmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    private final AssessmentRepository repo;

    public AssessmentService(AssessmentRepository repo) {
        this.repo = repo;
    }

    public Assessment save(Assessment assessment) {
        return repo.save(assessment);
    }

    public List<Assessment> getByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }
}