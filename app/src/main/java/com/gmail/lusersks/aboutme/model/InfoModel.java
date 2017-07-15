package com.gmail.lusersks.aboutme.model;

import com.gmail.lusersks.aboutme.model.entity.GithubUser;

import rx.Observable;

public interface InfoModel {
    Observable<GithubUser> retrieveInfo();
}
