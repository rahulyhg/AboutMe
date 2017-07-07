package com.gmail.lusersks.aboutme.model;


import java.util.ArrayList;
import java.util.List;

public class ProjectsModelImpl implements ProjectsModel {
    private static final int PROJECTS_COUNT = 5;
    private static String[] project = {"AboutMeAPK", "NotesAPK", "XObattle", "my-site", "sinatra"};
    private static String[] tag = {"Android", "Android", "Java", "Ruby", "Ruby"};
    private static String[] description = {
            "Android application about me",
            "Collect of notes and todos",
            "Game tic-tac-toe with the blob of AI",
            "My own Web-site",
            "Contribution project"
    };

    @Override
    public List<Project> retrieveInfo() {
        List<Project> list = new ArrayList<>();
        for (int i = 0; i < PROJECTS_COUNT; i++) {
            list.add(new Project(project[i], tag[i], description[i]));
        }
        return list;
    }
}
