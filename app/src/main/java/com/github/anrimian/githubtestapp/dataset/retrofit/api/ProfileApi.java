package com.github.anrimian.githubtestapp.dataset.retrofit.api;

import com.github.anrimian.githubtestapp.dataset.retrofit.requests.AuthRequest;
import com.github.anrimian.githubtestapp.dataset.retrofit.requests.UpdateProfileRequest;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth.AuthResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.user.UserInfoResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public interface ProfileApi {

    @GET("user")
    Single<UserInfoResponse> getProfileInfo(@Header("Authorization") String credentials);

    @POST("authorizations")
    Single<AuthResponse> createAuthorization(@Header("Authorization") String credentials,
                                             @Body AuthRequest authRequest);

    @PATCH("user")
    Single<UserInfoResponse> updateProfileInfo(@Header("Authorization") String credentials,
                                               @Body UpdateProfileRequest updateProfileRequest);
}
