package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.Student;
import com.skillgappro.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // 🔥 MAIN FIX (CLERK SYNC)
    public Student getOrCreate(String clerkId, String email, String name) {

        // ✅ 1. Check existing
        Optional<Student> existing = repo.findByClerkId(clerkId);

        if (existing.isPresent()) {
            return existing.get();
        }

        // ❌ Prevent null crash
        if (email == null || email.isEmpty()) {
            // 🔥 FIX: auto generate fallback email
            email = clerkId + "@temp.com";
        }
        // ✅ 2. Create new student
        Student student = new Student();
        student.setClerkId(clerkId);
        student.setEmail(email);
        student.setFullName(name != null ? name : "User");
        student.setRole("STUDENT");

        return repo.save(student);
    }

    // ✅ Other methods (keep same)
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public Student getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Student upgradeToPro(Long id) {
        Student student = getById(id);
        student.setIsPro(true);
        return repo.save(student);
    }
}