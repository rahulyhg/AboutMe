package com.gmail.lusersks.aboutme.model;

public class Project {
    private final String project;
    private final String tag;
    private final String description;

    Project(String project, String tag, String description) {
        this.project = project;
        this.tag = tag;
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }
}
