package com.gmail.lusersks.aboutme.model.entity;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class GithubUser {

    private String login;
    private String name;
    private String bio;

    @SerializedName("avatar_url")
    private String avatar;

    @Nullable
    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatar() {
        return avatar;
    }
}
