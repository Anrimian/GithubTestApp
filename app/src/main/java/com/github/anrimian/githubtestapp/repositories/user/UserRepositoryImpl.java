package com.github.anrimian.githubtestapp.repositories.user;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.GithubApi;
import com.github.anrimian.githubtestapp.repositories.user.models.UserInfoModel;
import com.github.anrimian.githubtestapp.repositories.user.models.UserModelMapper;

import org.mapstruct.factory.Mappers;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class UserRepositoryImpl implements UserRepository {

    @Inject
    GithubApi githubApi;

    private UserModelMapper userModelMapper = Mappers.getMapper(UserModelMapper.class);

    public UserRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<UserInfoModel> getUserInfo(String token) {
        return githubApi.getUserInfo("token " + token)
                .map(userModelMapper::mapUserInfoResponse);

    }
}
