package com.github.anrimian.githubtestapp.dataset.retrofit;

import com.github.anrimian.githubtestapp.dataset.retrofit.api.GithubApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 02.05.2017.
 */

public class RetrofitHolder {

    private static final String BASE_URL = "";//TODO set base url

    private GithubApi githubApi;

    public RetrofitHolder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createHttpClient())
                .build();
        githubApi = retrofit.create(GithubApi.class);
    }

    private OkHttpClient createHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(createHttpLoggingInterceptor())
                .build();
    }

    private HttpLoggingInterceptor createHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public GithubApi getGithubApi() {
        return githubApi;
    }
}
