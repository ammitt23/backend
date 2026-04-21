package com.skillgappro.backend.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GapEngineService {

    public List<Map<String, Object>> calculateGaps(List<Map<String, Object>> skillScores) {

        List<Map<String, Object>> gaps = new ArrayList<>();

        for (Map<String, Object> skill : skillScores) {
            int current = (int) skill.get("score");
            int required = (int) skill.get("required");

            int gap = required - current;

            if (gap > 0) {
                Map<String, Object> g = new HashMap<>();
                g.put("skillName", skill.get("skillName"));
                g.put("gapValue", gap);

                if (gap >= 5) g.put("priority", "Critical");
                else g.put("priority", "Moderate");

                gaps.add(g);
            }
        }

        return gaps;
    }
}
