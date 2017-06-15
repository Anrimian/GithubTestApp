package com.github.anrimian.githubtestapp.repositories.profile;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.ProfileApi;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.repositories.users.models.UserModelMapper;

import org.mapstruct.factory.Mappers;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class ProfileRepositoryImpl implements ProfileRepository {

    @Inject
    ProfileApi profileApi;

    private UserModelMapper userModelMapper = Mappers.getMapper(UserModelMapper.class);

    public ProfileRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<UserInfoModel> getProfileInfo(String token) {
        return profileApi.getProfileInfo("token " + token)
                .map(userModelMapper::mapUserInfoResponse);
    }

    @Override
    public Single<UserInfoModel> updateProfileInfo(String token, UserInfoModel userInfoModel) {
        return Single.fromCallable(() -> userInfoModel)
                .map(userModelMapper::mapUserInfoToUpdateRequest)
                .flatMap(request -> profileApi.updateProfileInfo("token " + token, request))
                .map(userModelMapper::mapUserInfoResponse);
    }
}
