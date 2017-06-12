package com.github.anrimian.githubtestapp.dataset.retrofit.responses.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 11.06.2017.
 */

public class UserPlanResponse {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("space")
    @Expose
    private Integer space;

    @SerializedName("collaborators")
    @Expose
    private Integer collaborators;

    @SerializedName("private_repos")
    @Expose
    private Integer privateRepos;

    public String getName() {
        return name;
    }

    public Integer getSpace() {
        return space;
    }

    public Integer getCollaborators() {
        return collaborators;
    }

    public Integer getPrivateRepos() {
        return privateRepos;
    }
}
