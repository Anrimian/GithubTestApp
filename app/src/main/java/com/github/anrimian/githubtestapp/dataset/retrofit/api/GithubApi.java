package com.github.anrimian.githubtestapp.dataset.retrofit.api;

import com.github.anrimian.githubtestapp.dataset.retrofit.requests.AuthRequest;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth.AuthResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.user.UserInfoResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created on 02.05.2017.
 */

public interface GithubApi {

    @GET("user")
    Single<UserInfoResponse> getUserInfo(@Header("Authorization") String credentials);

    @POST("authorizations")
    Single<AuthResponse> createAuthorization(@Header("Authorization") String credentials,
                                             @Body AuthRequest authRequest);
}
