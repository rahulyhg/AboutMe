package com.gmail.lusersks.aboutme.model;

class Skill {
    private String skill;
    private String years;
    private String level;

    public Skill(String skill, String years, String level) {
        this.skill = skill;
        this.years = years;
        this.level = level;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
