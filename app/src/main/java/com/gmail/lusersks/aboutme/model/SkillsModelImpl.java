package com.gmail.lusersks.aboutme.model;

import java.util.ArrayList;
import java.util.List;

public class SkillsModelImpl implements SkillsModel {
    private static final int SKILLS_COUNT = 6;
    private static String[] skill = {"Android", "Java", "Ruby on Rails", "JavaScript", "HTML", "CSS"};
    private static String[] years = {"1", "1", "1", "1", "2", "2"};
    private static String[] level = {"1", "2", "2", "2", "3", "2"};

    @Override
    public List<Skill> retrieveInfo() {
        List<Skill> list = new ArrayList<>();
        for (int i = 0; i < SKILLS_COUNT; i++) {
            list.add(new Skill(skill[i], years[i], level[i]));
        }
        return list;
    }
}
