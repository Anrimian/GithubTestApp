package com.github.anrimian.githubtestapp.dagger.components;

import com.github.anrimian.githubtestapp.dagger.modules.ApiModule;
import com.github.anrimian.githubtestapp.dagger.modules.AppModule;
import com.github.anrimian.githubtestapp.dagger.modules.BusinessModule;
import com.github.anrimian.githubtestapp.dagger.modules.DataModule;
import com.github.anrimian.githubtestapp.features.screens.auth.SignInPresenter;
import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.profile.ProfilePresenter;
import com.github.anrimian.githubtestapp.features.screens.main.profile.business.ProfileInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.EditProfilePresenter;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business.EditProfileInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.repo.RepoListPresenter;
import com.github.anrimian.githubtestapp.features.screens.main.repo.business.RepoListInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.users.UsersPresenter;
import com.github.anrimian.githubtestapp.features.screens.main.users.business.UsersInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.users.screens.user.UserPresenter;
import com.github.anrimian.githubtestapp.features.screens.main.users.screens.user.business.UserInteractorImpl;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.profile.ProfileRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.repo.RepoRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.users.UserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class, DataModule.class, BusinessModule.class})
public interface AppComponent {

    void inject(SecurityRepositoryImpl securityRepository);

    void inject(SignInPresenter signInPresenter);

    void inject(SignInInteractorImpl signInInteractor);

    void inject(UserRepositoryImpl userRepository);

    void inject(PreferencesRepositoryImpl preferencesRepository);

    void inject(ProfileInteractorImpl profileInteractor);

    void inject(ProfilePresenter profilePresenter);

    void inject(RepoRepositoryImpl repoRepository);

    void inject(ProfileRepositoryImpl profileRepository);

    void inject(RepoListInteractorImpl repoListInteractor);

    void inject(RepoListPresenter repoListPresenter);

    void inject(UsersInteractorImpl usersInteractor);

    void inject(UsersPresenter usersPresenter);

    void inject(UserPresenter userPresenter);

    void inject(UserInteractorImpl userInteractor);

    void inject(EditProfileInteractorImpl editProfileInteractor);

    void inject(EditProfilePresenter editProfilePresenter);
}
