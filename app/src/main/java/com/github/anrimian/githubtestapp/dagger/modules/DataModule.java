package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.profile.ProfileRepository;
import com.github.anrimian.githubtestapp.repositories.profile.ProfileRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.repo.RepoRepository;
import com.github.anrimian.githubtestapp.repositories.repo.RepoRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepository;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.users.UserRepository;
import com.github.anrimian.githubtestapp.repositories.users.UserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 11.06.2017.
 */

@Module
public class DataModule {

    @Provides
    @NonNull
    SecurityRepository provideSecurityRepository() {
        return new SecurityRepositoryImpl();
    }

    @Provides
    @NonNull
    UserRepository provideUserRepository() {
        return new UserRepositoryImpl();
    }

    @Provides
    @NonNull
    @Singleton
    PreferencesRepository providePreferencesRepository() {
        return new PreferencesRepositoryImpl();
    }

    @Provides
    @NonNull
    RepoRepository provideRepoRepository() {
        return new RepoRepositoryImpl();
    }

    @Provides
    @NonNull
    ProfileRepository provideProfileRepository() {
        return new ProfileRepositoryImpl();
    }


}
