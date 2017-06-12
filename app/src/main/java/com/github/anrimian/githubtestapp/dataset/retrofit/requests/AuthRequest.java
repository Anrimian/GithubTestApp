package com.github.anrimian.githubtestapp.dataset.retrofit.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class AuthRequest {

    @SerializedName("client_id")
    @Expose
    private String clientId;

    @SerializedName("client_secret")
    @Expose
    private String clientSecret;

    @SerializedName("note")
    @Expose
    private String note;

    @SerializedName("scopes")
    @Expose
    private List<String> scopes = null;

    public AuthRequest(String clientId, String clientSecret, String note, List<String> scopes) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.note = note;
        this.scopes = scopes;
    }
}
