package com.gmail.lusersks.aboutme.model;

import com.gmail.lusersks.aboutme.model.api.GithubService;
import com.gmail.lusersks.aboutme.model.entity.GithubUser;

import rx.Observable;
import rx.schedulers.Schedulers;

public class InfoModelImpl implements InfoModel {

    private String user;
    private GithubService api;

    public InfoModelImpl(String user, GithubService api) {
        this.user = user;
        this.api = api;
    }

    @Override
    public Observable<GithubUser> retrieveInfo() {
        /*List<String> list = new ArrayList<>();
        list.add("RAMAN SKASKEVICH");
        list.add("SOFTWARE DEVELOPER and TESTER");
        list.add("RUBY and JAVA AMATEUR");
        return Observable.from(list).buffer(3);*/
        return api.getUser(user).subscribeOn(Schedulers.io());
    }
}
