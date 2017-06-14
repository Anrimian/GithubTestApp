package com.github.anrimian.githubtestapp.dataset.retrofit.responses.repo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 14.6.17. It is awesome java class.
 */

public class PermissionsResponse {

    @SerializedName("admin")
    @Expose
    private Boolean admin;

    @SerializedName("push")
    @Expose
    private Boolean push;

    @SerializedName("pull")
    @Expose
    private Boolean pull;

    public Boolean getAdmin() {
        return admin;
    }

    public Boolean getPush() {
        return push;
    }

    public Boolean getPull() {
        return pull;
    }
}
