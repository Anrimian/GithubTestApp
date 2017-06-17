package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractor;
import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.profile.business.ProfileInteractor;
import com.github.anrimian.githubtestapp.features.screens.main.profile.business.ProfileInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business.EditProfileInteractor;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business.EditProfileInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.repo.business.RepoListInteractor;
import com.github.anrimian.githubtestapp.features.screens.main.repo.business.RepoListInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.users.business.UsersInteractor;
import com.github.anrimian.githubtestapp.features.screens.main.users.business.UsersInteractorImpl;
import com.github.anrimian.githubtestapp.features.screens.main.users.screens.user.business.UserInteractor;
import com.github.anrimian.githubtestapp.features.screens.main.users.screens.user.business.UserInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 11.06.2017.
 */

@Module
public class BusinessModule {

    @Provides
    @NonNull
    SignInInteractor provideSignInInteractor() {
        return new SignInInteractorImpl();
    }

    @Provides
    @NonNull
    @Singleton
    ProfileInteractor provideProfileInteractor() {
        return new ProfileInteractorImpl();
    }

    @Provides
    @NonNull
    RepoListInteractor provideRepoListInteractor() {
        return new RepoListInteractorImpl();
    }

    @Provides
    @NonNull
    UsersInteractor provideUsersInteractor() {
        return new UsersInteractorImpl();
    }

    @Provides
    @NonNull
    UserInteractor provideUserInteractor() {
        return new UserInteractorImpl();
    }

    @Provides
    @NonNull
    EditProfileInteractor provideEditProfileInteractor() {
        return new EditProfileInteractorImpl();
    }

}
