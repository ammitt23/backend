package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.Notification;
import com.skillgappro.backend.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public Notification create(Notification notification) {
        return repo.save(notification);
    }

    public List<Notification> getByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }
}