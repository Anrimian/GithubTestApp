package com.github.anrimian.githubtestapp.features.screens.main.users.screens.user.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.users.UserRepository;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public class UserInteractorImpl implements UserInteractor {

    @Inject
    UserRepository userRepository;

    @Inject
    PreferencesRepository preferencesRepository;

    public UserInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<UserInfoModel> getUserInfo(String login) {
        return userRepository.getUserInfo(login, preferencesRepository.getToken());
    }
}
