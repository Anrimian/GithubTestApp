package com.github.anrimian.githubtestapp.repositories.profile;

import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import io.reactivex.Single;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public interface ProfileRepository {

    Single<UserInfoModel> getProfileInfo(String token);
}
