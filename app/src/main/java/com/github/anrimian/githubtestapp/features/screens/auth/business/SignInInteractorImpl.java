package com.github.anrimian.githubtestapp.features.screens.auth.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.auth.business.validator.LoginValidator;
import com.github.anrimian.githubtestapp.features.screens.auth.business.validator.PasswordValidator;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created on 11.06.2017.
 */

public class SignInInteractorImpl implements SignInInteractor {

    @Inject
    SecurityRepository securityRepository;

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
                .toCompletable();
    }
}
