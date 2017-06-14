package com.github.anrimian.githubtestapp.repositories.user.models;

/**
 * Created on 11.06.2017.
 */

public class UserInfoModel {

    private long id;

    private String login;
    private String avatar;
    private String name;
    private String company;
    private String email;
    private String repositoriesUrl;

    private int publicRepoCount;
    private int privateGistsCount;
    private int privateRepositoriesCount;
    private int ownedPrivateRepositoriesCount;

    public int getPublicRepoCount() {
        return publicRepoCount;
    }

    public void setPublicRepoCount(int publicRepoCount) {
        this.publicRepoCount = publicRepoCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepositoriesUrl() {
        return repositoriesUrl;
    }

    public void setRepositoriesUrl(String repositoriesUrl) {
        this.repositoriesUrl = repositoriesUrl;
    }

    public int getPrivateGistsCount() {
        return privateGistsCount;
    }

    public void setPrivateGistsCount(int privateGistsCount) {
        this.privateGistsCount = privateGistsCount;
    }

    public int getPrivateRepositoriesCount() {
        return privateRepositoriesCount;
    }

    public void setPrivateRepositoriesCount(int privateRepositoriesCount) {
        this.privateRepositoriesCount = privateRepositoriesCount;
    }

    public int getOwnedPrivateRepositoriesCount() {
        return ownedPrivateRepositoriesCount;
    }

    public void setOwnedPrivateRepositoriesCount(int ownedPrivateRepositoriesCount) {
        this.ownedPrivateRepositoriesCount = ownedPrivateRepositoriesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", repositoriesUrl='" + repositoriesUrl + '\'' +
                ", privateGistsCount=" + privateGistsCount +
                ", privateRepositoriesCount=" + privateRepositoriesCount +
                ", ownedPrivateRepositoriesCount=" + ownedPrivateRepositoriesCount +
                '}';
    }
}
