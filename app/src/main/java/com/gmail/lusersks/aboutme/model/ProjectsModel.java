package com.gmail.lusersks.aboutme.model;

import com.gmail.lusersks.aboutme.model.entity.Project;

import java.util.List;

import rx.Observable;

public interface ProjectsModel {
    Observable<List<Project>> retrieveInfo();
}
