package com.github.anrimian.githubtestapp.dataset.retrofit.api;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth.UserInfoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created on 02.05.2017.
 */

public interface GithubApi {

    @GET("user")
    Single<UserInfoResponse> getUserInfo(@Header("Authorization") String credentials);
}
