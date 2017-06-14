package com.github.anrimian.githubtestapp.repositories.repo.models;

/**
 * Created on 14.6.17. It is awesome java class.
 */

public class RepoInfoModel {

    private String name;
    private String description;
    private String htmlUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
