package com.github.anrimian.githubtestapp.repositories.users.models;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class UserSearchResult {

    private String login;

    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
