package com.github.anrimian.githubtestapp.features.screens.main.profile.business;

import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface ProfileInteractor {

    Single<UserInfoModel> getProfileInfo();

    Observable<UserInfoModel> getProfileInfoObservable();

    void notifyProfileInfoChanged(UserInfoModel userInfoModel);
}
