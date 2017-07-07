package com.gmail.lusersks.aboutme.presenter;


import com.gmail.lusersks.aboutme.view.ProjectsView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

public interface ProjectsPresenter extends MvpPresenter<ProjectsView> {
    void loadProjects();
}
