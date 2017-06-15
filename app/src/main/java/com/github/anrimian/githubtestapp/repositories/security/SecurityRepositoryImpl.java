package com.github.anrimian.githubtestapp.repositories.security;

import android.util.Base64;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.retrofit.RetrofitHolder;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.ProfileApi;
import com.github.anrimian.githubtestapp.dataset.retrofit.requests.AuthRequest;
import com.github.anrimian.githubtestapp.repositories.security.models.AuthModelMapper;
import com.github.anrimian.githubtestapp.repositories.security.models.AuthorizationInfo;

import org.mapstruct.factory.Mappers;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 11.06.2017.
 */

public class SecurityRepositoryImpl implements SecurityRepository {

    @Inject
    ProfileApi profileApi;

    private AuthModelMapper authModelMapper = Mappers.getMapper(AuthModelMapper.class);

    public SecurityRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<AuthorizationInfo> signIn(String username, String password) {
        String encode = Base64.encodeToString((username + ":" + password).getBytes(), Base64.DEFAULT)
                .replace("\n", "");
        encode = "Basic " + encode;

        AuthRequest authRequest = new AuthRequest(RetrofitHolder.CLIENT_ID,
                RetrofitHolder.CLIENT_SECRET,
                RetrofitHolder.APP_NOTE,
                RetrofitHolder.GITHUB_SCOPES);
        return profileApi.createAuthorization(encode, authRequest)
                .map(authModelMapper::mapAuthResponse);
    }
}
