package com.github.anrimian.githubtestapp.features.screens.main.profile.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.profile.ProfileRepository;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public class ProfileInteractorImpl implements ProfileInteractor {

    @Inject
    ProfileRepository profileRepository;

    @Inject
    PreferencesRepository preferencesRepository;

    private PublishSubject<UserInfoModel> profileInfoSubject = PublishSubject.create();

    public ProfileInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<UserInfoModel> getProfileInfo() {
        return profileRepository.getProfileInfo(preferencesRepository.getToken());
    }

    @Override
    public Observable<UserInfoModel> getProfileInfoObservable() {
        return profileInfoSubject;
    }

    @Override
    public void notifyProfileInfoChanged(UserInfoModel userInfoModel) {
        profileInfoSubject.onNext(userInfoModel);
    }
}
