package com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 11.06.2017.
 */

public class UserInfoResponse {

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("gravatar_id")
    @Expose
    private String gravatarId;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    @SerializedName("followers_url")
    @Expose
    private String followersUrl;

    @SerializedName("following_url")
    @Expose
    private String followingUrl;

    @SerializedName("gists_url")
    @Expose
    private String gistsUrl;

    @SerializedName("starred_url")
    @Expose
    private String starredUrl;

    @SerializedName("subscriptions_url")
    @Expose
    private String subscriptionsUrl;

    @SerializedName("organizations_url")
    @Expose
    private String organizationsUrl;

    @SerializedName("repos_url")
    @Expose
    private String reposUrl;

    @SerializedName("events_url")
    @Expose
    private String eventsUrl;

    @SerializedName("received_events_url")
    @Expose
    private String receivedEventsUrl;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("site_admin")
    @Expose
    private Boolean siteAdmin;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("company")
    @Expose
    private Object company;

    @SerializedName("blog")
    @Expose
    private String blog;

    @SerializedName("location")
    @Expose
    private Object location;

    @SerializedName("email")
    @Expose
    private Object email;

    @SerializedName("hireable")
    @Expose
    private Object hireable;

    @SerializedName("bio")
    @Expose
    private Object bio;

    @SerializedName("public_repos")
    @Expose
    private Integer publicRepos;

    @SerializedName("public_gists")
    @Expose
    private Integer publicGists;

    @SerializedName("followers")
    @Expose
    private Integer followers;

    @SerializedName("following")
    @Expose
    private Integer following;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("private_gists")
    @Expose
    private Integer privateGists;

    @SerializedName("total_private_repos")
    @Expose
    private Integer totalPrivateRepos;

    @SerializedName("owned_private_repos")
    @Expose
    private Integer ownedPrivateRepos;

    @SerializedName("disk_usage")
    @Expose
    private Integer diskUsage;

    @SerializedName("collaborators")
    @Expose
    private Integer collaborators;

    @SerializedName("two_factor_authentication")
    @Expose
    private Boolean twoFactorAuthentication;

    @SerializedName("plan")
    @Expose
    private UserPlanResponse plan;

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public String getName() {
        return name;
    }

    public Object getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public Object getLocation() {
        return location;
    }

    public Object getEmail() {
        return email;
    }

    public Object getHireable() {
        return hireable;
    }

    public Object getBio() {
        return bio;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public Integer getPublicGists() {
        return publicGists;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Integer getPrivateGists() {
        return privateGists;
    }

    public Integer getTotalPrivateRepos() {
        return totalPrivateRepos;
    }

    public Integer getOwnedPrivateRepos() {
        return ownedPrivateRepos;
    }

    public Integer getDiskUsage() {
        return diskUsage;
    }

    public Integer getCollaborators() {
        return collaborators;
    }

    public Boolean getTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    public UserPlanResponse getPlan() {
        return plan;
    }
}
