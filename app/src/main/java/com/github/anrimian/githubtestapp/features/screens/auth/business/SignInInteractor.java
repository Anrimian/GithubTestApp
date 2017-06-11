package com.github.anrimian.githubtestapp.features.screens.auth.business;

import io.reactivex.Completable;

/**
 * Created on 11.06.2017.
 */

public interface SignInInteractor {

    Completable signIn(String login, String password);
}
