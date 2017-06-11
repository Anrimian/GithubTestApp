package com.github.anrimian.githubtestapp.repositories.security;

import android.util.Base64;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.GithubApi;
import com.github.anrimian.githubtestapp.repositories.security.models.UserInfoModel;
import com.github.anrimian.githubtestapp.repositories.security.models.UserModelMapper;

import org.mapstruct.factory.Mappers;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 11.06.2017.
 */

public class SecurityRepositoryImpl implements SecurityRepository {

    @Inject
    GithubApi githubApi;

    private UserModelMapper userModelMapper = Mappers.getMapper(UserModelMapper.class);

    public SecurityRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<UserInfoModel> signIn(String username, String password) {
        String encode = Base64.encodeToString((username + ":" + password).getBytes(), Base64.DEFAULT)
                .replace("\n", "");
        encode = "Basic " + encode;
        return githubApi.getUserInfo(encode)
                .map(userModelMapper::mapUserInfoResponse);
    }
}
