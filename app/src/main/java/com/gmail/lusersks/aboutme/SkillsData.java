package com.gmail.lusersks.aboutme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SkillsData {

    static final String FIELD_SKILL = "skills";
    static final String FIELD_EXPERIENCE = "experience";
    static final String FIELD_LEVEL = "level";

    private static String[] skills = {"Android", "Java", "Ruby on Rails", "JavaScript", "HTML", "CSS"};
    private static String[] experience_year = {"0.5", "1", "1", "1", "2", "2"};
    private static String[] level_1to5 = {"1", "2", "2", "2", "3", "2"};

    static List<Map<String, String>> getItems() {
        final List<Map<String, String>> items = new ArrayList<>();
        for (int i = 0; i < skills.length; i++) {
            final Map<String, String> map = new HashMap<>(2);
            map.put(FIELD_SKILL, skills[i]);
            map.put(FIELD_EXPERIENCE, experience_year[i]);
            map.put(FIELD_LEVEL, level_1to5[i]);
            items.add(map);
        }
        return items;
    }
}
