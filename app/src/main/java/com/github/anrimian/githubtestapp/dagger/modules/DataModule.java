package com.github.anrimian.githubtestapp.dagger.modules;

import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.repositories.security.SecurityRepository;
import com.github.anrimian.githubtestapp.repositories.security.SecurityRepositoryImpl;

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
}
