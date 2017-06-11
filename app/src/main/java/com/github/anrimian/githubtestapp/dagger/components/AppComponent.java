package com.github.anrimian.githubtestapp.dagger.components;

import com.github.anrimian.githubtestapp.dagger.modules.ApiModule;
import com.github.anrimian.githubtestapp.dagger.modules.AppModule;
import com.github.anrimian.githubtestapp.dagger.modules.BusinessModule;
import com.github.anrimian.githubtestapp.dagger.modules.DataModule;
import com.github.anrimian.githubtestapp.features.screens.auth.SignInPresenter;
import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractorImpl;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepositoryImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class, DataModule.class, BusinessModule.class})
public interface AppComponent {

    void inject(SecurityRepositoryImpl securityRepository);

    void inject(SignInPresenter signInPresenter);

    void inject(SignInInteractorImpl signInInteractor);
}
