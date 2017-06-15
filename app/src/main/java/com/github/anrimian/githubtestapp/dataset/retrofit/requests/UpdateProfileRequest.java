package com.github.anrimian.githubtestapp.dataset.retrofit.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class UpdateProfileRequest {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("blog")
    @Expose
    private String blog;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("hireable")
    @Expose
    private Boolean hireable;

    @SerializedName("bio")
    @Expose
    private String bio;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHireable(Boolean hireable) {
        this.hireable = hireable;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
