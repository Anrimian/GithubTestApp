package com.github.anrimian.githubtestapp.dataset.retrofit.api;

import com.github.anrimian.githubtestapp.dataset.retrofit.requests.AuthRequest;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth.AuthResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.repo.RepoResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.search.SearchUsersResultResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.user.UserInfoResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created on 02.05.2017.
 */

public interface GithubApi {

    @GET("user")
    Single<UserInfoResponse> getUserInfo(@Header("Authorization") String credentials);

    @POST("authorizations")
    Single<AuthResponse> createAuthorization(@Header("Authorization") String credentials,
                                             @Body AuthRequest authRequest);

    @GET("users/{username}/repos")
    Single<List<RepoResponse>> getRepoList(@Header("Authorization") String credentials,
                                           @Query("username") String userName);

    /**
     *
     * @param page pagination starting from 1 (!)
     */
    @GET("search/users")
    Single<SearchUsersResultResponse> searchUsers(@Query("q") String query,
                                                  @Query("page") int page,
                                                  @Query("per_page") int perPage);
}
