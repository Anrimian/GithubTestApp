package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.dataset.retrofit.RetrofitHolder;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.ProfileApi;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.RepoApi;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.UsersApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 11.02.2017.
 */

@Module
public class ApiModule {

    private RetrofitHolder retrofitHolder;

    public ApiModule() {
        retrofitHolder = new RetrofitHolder();
    }

    @Provides
    @NonNull
    ProfileApi getProfileApi() {
        return retrofitHolder.getProfileApi();
    }

    @Provides
    @NonNull
    RepoApi getRepoApi() {
        return retrofitHolder.getRepoApi();
    }

    @Provides
    @NonNull
    UsersApi getUsersApi() {
        return retrofitHolder.getUsersApi();
    }
}
