package com.github.anrimian.githubtestapp.features.screens.main.profile.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.user.UserRepository;
import com.github.anrimian.githubtestapp.repositories.user.models.UserInfoModel;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public class ProfileInteractorImpl implements ProfileInteractor {

    @Inject
    UserRepository userRepository;

    @Inject
    PreferencesRepository preferencesRepository;

    public ProfileInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<UserInfoModel> getUserInfo() {
        return userRepository.getUserInfo(preferencesRepository.getToken());
    }
}
