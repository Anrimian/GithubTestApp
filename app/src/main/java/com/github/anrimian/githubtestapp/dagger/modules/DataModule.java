package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepository;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepositoryImpl;
import com.github.anrimian.githubtestapp.repositories.user.UserRepository;
import com.github.anrimian.githubtestapp.repositories.user.UserRepositoryImpl;

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
}
