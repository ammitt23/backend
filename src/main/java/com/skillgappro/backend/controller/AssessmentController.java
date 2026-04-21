package com.skillgappro.backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @GetMapping("/student/{id}/latest")
    public Map<String, Object> getLatest(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        res.put("score", 0);
        res.put("message", "No assessment yet");
        return res;
    }

    @GetMapping("/student/{id}/gaps")
    public List<Map<String, Object>> getGaps(@PathVariable Long id) {
        return new ArrayList<>(); // empty list
    }
}