package com.github.anrimian.githubtestapp.dataset.retrofit.responses;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created on 11.06.2017.
 */

public class ErrorResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("errors")
    @Expose
    private List<ErrorDetail> errors = null;

    @Nullable
    public static ErrorResponse fromHttpException(HttpException httpException) {
        ResponseBody body = httpException.response().errorBody();
        Gson gson = new Gson();
        TypeAdapter<ErrorResponse> adapter = gson.getAdapter(ErrorResponse.class);
        try {
            return adapter.fromJson(body.string());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getMessage() {
        return message;
    }

    @Nullable
    public List<ErrorDetail> getErrors() {
        return errors;
    }
}
