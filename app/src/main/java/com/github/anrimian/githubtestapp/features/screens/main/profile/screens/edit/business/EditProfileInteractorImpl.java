package com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.main.profile.business.ProfileInteractor;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business.validator.UserInfoValidator;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.profile.ProfileRepository;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public class EditProfileInteractorImpl implements EditProfileInteractor {

    @Inject
    ProfileRepository profileRepository;

    @Inject
    PreferencesRepository preferencesRepository;

    @Inject
    ProfileInteractor profileInteractor;

    private UserInfoValidator userInfoValidator = new UserInfoValidator();

    public EditProfileInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Completable changeProfileInfo(UserInfoModel userInfoModel) {
        return userInfoValidator.validate(userInfoModel)
                .flatMap(info -> profileRepository.updateProfileInfo(preferencesRepository.getToken(), userInfoModel))
                .doOnSuccess(profileInteractor::notifyProfileInfoChanged)
                .toCompletable();
    }
}
