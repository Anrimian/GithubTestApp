package com.github.anrimian.githubtestapp.dataset.retrofit.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 11.06.2017.
 */

public class ErrorDetail {

    @SerializedName("resource")
    @Expose
    private String resource;

    @SerializedName("field")
    @Expose
    private String field;

    @SerializedName("code")
    @Expose
    private String code;

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }
}
