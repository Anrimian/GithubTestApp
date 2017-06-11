package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.dataset.retrofit.RetrofitHolder;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.GithubApi;

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
    public GithubApi getAuthApi() {
        return retrofitHolder.getGithubApi();
    }
}
