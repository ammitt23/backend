//package com.skillgappro.backend.controller;
//
//import com.skillgappro.backend.entity.Student;
//import com.skillgappro.backend.service.StudentService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/students")
//
//public class StudentController {
//
//    private final StudentService service;
//
//    public StudentController(StudentService service) {
//        this.service = service;
//    }
//
//    // 🔥 1. Clerk Sync (SAFE + DEBUG VERSION)
//    @GetMapping("/clerk/{clerkId}")
//    public ResponseEntity<?> getOrCreate(
//            @PathVariable String clerkId,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String name) {
//
//        try {
//            // 🔥 DEBUG LOGS
//            System.out.println("👉 ClerkId: " + clerkId);
//            System.out.println("👉 Email: " + email);
//            System.out.println("👉 Name: " + name);
//
//            // ❌ Prevent invalid calls
//            if (clerkId == null || clerkId.equals("undefined") || clerkId.isEmpty()) {
//                return ResponseEntity.badRequest().body("Invalid clerkId");
//            }
//
//            // 🔥 AUTO FIX EMAIL (IMPORTANT)
//            if (email == null || email.isEmpty()) {
//                email = clerkId + "@temp.com"; // fallback email
//                System.out.println("⚠️ Email auto-generated: " + email);
//            }
//
//            // 🔥 AUTO FIX NAME
//            if (name == null || name.isEmpty()) {
//                name = "User";
//            }
//
//            Student student = service.getOrCreate(clerkId, email, name);
//
//            return ResponseEntity.ok(student);
//
//        } catch (Exception e) {
//            e.printStackTrace(); // 🔥 DEBUG
//            return ResponseEntity.status(500).body("Error creating/fetching user");
//        }
//    }
//
//    // ✅ 2. Get all students
//    @GetMapping
//    public List<Student> getAll() {
//        return service.getAllStudents();
//    }
//
//    // ✅ 3. Create student
//    @PostMapping
//    public Student create(@RequestBody Student student) {
//        return service.saveStudent(student);
//    }
//
//    // ✅ 4. Get by ID
//    @GetMapping("/{id}")
//    public Student getById(@PathVariable Long id) {
//        return service.getById(id);
//    }
//
//    // ✅ 5. Delete
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.delete(id);
//    }
//
//    // ✅ 6. Upgrade to Pro
//    @PatchMapping("/{id}/upgrade")
//    public Student upgradeToPro(@PathVariable Long id) {
//        return service.upgradeToPro(id);
//    }
//}

package com.skillgappro.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.skillgappro.backend.entity.StudentProfile;
import com.skillgappro.backend.repository.StudentProfileRepository;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    private final StudentProfileRepository profileRepository;

    public StudentController(StudentProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // ✅ Save onboarding data
    @PostMapping("/profile")
    public StudentProfile saveProfile(@RequestBody StudentProfile profile) {
        return profileRepository.save(profile);
    }
}