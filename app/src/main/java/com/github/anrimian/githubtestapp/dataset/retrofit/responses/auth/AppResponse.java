package com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class AppResponse {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("client_id")
    @Expose
    private String clientId;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getClientId() {
        return clientId;
    }
}
