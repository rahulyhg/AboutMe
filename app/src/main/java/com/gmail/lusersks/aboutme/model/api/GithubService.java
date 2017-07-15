package com.gmail.lusersks.aboutme.model.api;

import com.gmail.lusersks.aboutme.model.entity.GithubUser;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubService {

    @GET("users/{user}")
    Observable<GithubUser> getUser(@Path("user") String user);

}
