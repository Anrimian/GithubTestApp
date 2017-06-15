package com.github.anrimian.githubtestapp.dataset.retrofit.api;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.search.SearchUsersResultResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.user.UserInfoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public interface UsersApi {

    /**
     *
     * @param page pagination starting from 1 (!)
     */
    @GET("search/users")
    Single<SearchUsersResultResponse> searchUsers(@Query("q") String query,
                                                  @Query("page") int page,
                                                  @Query("per_page") int perPage);

    @GET("users/{username}")
    Single<UserInfoResponse> getUserInfo(@Query("username") String userName);
}