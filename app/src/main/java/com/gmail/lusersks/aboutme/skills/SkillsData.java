package com.gmail.lusersks.aboutme.skills;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.SkillsActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillsData {

    public static final String FIELD_SKILL = "skills";
    public static final String FIELD_EXPERIENCE = "experience";
    public static final String FIELD_LEVEL = "level";

    private static List<String> skills = new ArrayList<>();
    private static List<String> experience_year = new ArrayList<>();
    private static List<String> level_1to5 = new ArrayList<>();

    public static List<Map<String, String>> getItems(SkillsActivity activity) {
        getSkillsData(activity);

        final List<Map<String, String>> items = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++) {
            final Map<String, String> map = new HashMap<>(2);

            map.put(FIELD_SKILL, skills.get(i));
            map.put(FIELD_EXPERIENCE, experience_year.get(i));
            map.put(FIELD_LEVEL, level_1to5.get(i));

            items.add(map);
        }
        return items;
    }

    private static void getSkillsData(SkillsActivity activity) {
        skills = Arrays.asList(activity
                .getResources()
                .getStringArray(R.array.skills_array)
        );
        experience_year = Arrays.asList(activity
                .getResources()
                .getStringArray(R.array.experience_year_array)
        );
        level_1to5 = Arrays.asList(activity
                .getResources()
                .getStringArray(R.array.level_1to5_array)
        );
    }

    public static void addItem(String skill) {
        skills.add(skill);
        experience_year.add("1");
        level_1to5.add("1");
    }

    public static void deleteItem(String item) {
        int index = skills.indexOf(item);
        skills.remove(index);
        experience_year.remove(index);
        level_1to5.remove(index);
    }

    public static void modifyItem(String item) {
        int index = skills.indexOf(item);
        skills.set(index, item);
        experience_year.set(index, "1");
        level_1to5.set(index, "1");
    }
}
