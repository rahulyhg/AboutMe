package com.gmail.lusersks.aboutme.model.entity;

import com.google.gson.annotations.SerializedName;

public class Project {

    private String name;
    private String description;
    private String language;

    @SerializedName("html_url")
    private String url;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getUrl() {
        return url;
    }
}
