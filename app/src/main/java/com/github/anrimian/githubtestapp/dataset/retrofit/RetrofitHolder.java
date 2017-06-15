package com.github.anrimian.githubtestapp.dataset.retrofit;

import com.github.anrimian.githubtestapp.dataset.retrofit.api.ProfileApi;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.RepoApi;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.UsersApi;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 02.05.2017.
 */

public class RetrofitHolder {

    private static final String BASE_URL = "https://api.github.com/";
    public static final String CLIENT_ID = "24aebaa9503482c29956";
    public static final String CLIENT_SECRET = "c7ab10f0afc816de258bd51ec86de870beeb2a7f";
    public static final String APP_NOTE = "github_test_app";
    public static final List<String> GITHUB_SCOPES = new ArrayList<>();

    static {
        GITHUB_SCOPES.add("user");
    }


    private ProfileApi profileApi;
    private RepoApi repoApi;
    private UsersApi usersApi;

    public RetrofitHolder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createHttpClient())
                .build();
        profileApi = retrofit.create(ProfileApi.class);
        repoApi = retrofit.create(RepoApi.class);
        usersApi = retrofit.create(UsersApi.class);
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

    public ProfileApi getProfileApi() {
        return profileApi;
    }

    public RepoApi getRepoApi() {
        return repoApi;
    }

    public UsersApi getUsersApi() {
        return usersApi;
    }
}
