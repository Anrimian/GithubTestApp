package com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business;

import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import io.reactivex.Completable;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface EditProfileInteractor {

    Completable changeProfileInfo(UserInfoModel userInfoModel);
}
