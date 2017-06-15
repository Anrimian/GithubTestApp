package com.github.anrimian.githubtestapp.dataset.retrofit.api;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.repo.RepoResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public interface RepoApi {

    @GET("users/{username}/repos")
    Single<List<RepoResponse>> getRepoList(@Header("Authorization") String credentials,
                                           @Path("username") String userName);
}
