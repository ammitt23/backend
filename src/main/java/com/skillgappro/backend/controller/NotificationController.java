package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Notification;
import com.skillgappro.backend.repository.NotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")

public class NotificationController {

    private final NotificationRepository repo;

    public NotificationController(NotificationRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{studentId}")
    public List<Notification> getNotifications(@PathVariable Long studentId) {
        return repo.findByStudentId(studentId);
    }
}
