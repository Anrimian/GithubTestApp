package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractor;
import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 11.06.2017.
 */

@Module
public class BusinessModule {

    @Provides
    @NonNull
    public SignInInteractor provideSignInInteractor() {
        return new SignInInteractorImpl();
    }
}
