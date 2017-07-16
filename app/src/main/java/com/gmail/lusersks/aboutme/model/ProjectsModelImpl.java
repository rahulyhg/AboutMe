package com.gmail.lusersks.aboutme.model;


import com.gmail.lusersks.aboutme.model.api.GithubService;
import com.gmail.lusersks.aboutme.model.entity.Project;

import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class ProjectsModelImpl implements ProjectsModel {
    private String user;
    private GithubService api;

    public ProjectsModelImpl(String user, GithubService api) {
        this.user = user;
        this.api = api;
    }

    @Override
    public Observable<List<Project>> retrieveInfo() {
        return api.getRepos(user).subscribeOn(Schedulers.io());
    }
}
