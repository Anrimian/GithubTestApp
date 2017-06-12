package com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class AuthResponse {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("app")
    @Expose
    private AppResponse app;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("hashed_token")
    @Expose
    private String hashedToken;

    @SerializedName("token_last_eight")
    @Expose
    private String tokenLastEight;

    @SerializedName("note")
    @Expose
    private String note;

    @SerializedName("note_url")
    @Expose
    private Object noteUrl;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("scopes")
    @Expose
    private List<String> scopes = null;

    @SerializedName("fingerprint")
    @Expose
    private Object fingerprint;

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public AppResponse getApp() {
        return app;
    }

    public String getToken() {
        return token;
    }

    public String getHashedToken() {
        return hashedToken;
    }

    public String getTokenLastEight() {
        return tokenLastEight;
    }

    public String getNote() {
        return note;
    }

    public Object getNoteUrl() {
        return noteUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public Object getFingerprint() {
        return fingerprint;
    }
}
