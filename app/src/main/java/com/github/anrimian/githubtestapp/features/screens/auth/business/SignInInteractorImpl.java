package com.github.anrimian.githubtestapp.features.screens.auth.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.auth.business.validator.LoginValidator;
import com.github.anrimian.githubtestapp.features.screens.auth.business.validator.PasswordValidator;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepository;
import com.github.anrimian.githubtestapp.repositories.security.models.AuthorizationInfo;
import com.github.anrimian.githubtestapp.repositories.users.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created on 11.06.2017.
 */

public class SignInInteractorImpl implements SignInInteractor {

    @Inject
    SecurityRepository securityRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    PreferencesRepository preferencesRepository;

    private LoginValidator loginValidator = new LoginValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();

    public SignInInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Completable signIn(String login, String password) {
        return loginValidator.validate(login)
                .flatMap(o -> passwordValidator.validate(password))
                .flatMap(o -> securityRepository.signIn(login, password))
                .map(AuthorizationInfo::getToken)
                .map(token -> "token " + token)
                .doOnSuccess(preferencesRepository::setToken)
                //.flatMap(userRepository::getUserInfo)//TODO first implement user info saving
                .toCompletable();
    }
}
