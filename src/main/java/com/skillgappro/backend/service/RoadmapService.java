package com.skillgappro.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoadmapService {

    public List<Map<String, Object>> generateRoadmap(List<Map<String, Object>> gaps) {

        for (Map<String, Object> g : gaps) {
            if ("Critical".equals(g.get("priority"))) {
                g.put("suggestion", "Focus immediately with daily practice");
            } else {
                g.put("suggestion", "Improve gradually with weekly plan");
            }
        }

        return gaps;
    }
}