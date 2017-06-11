package com.github.anrimian.githubtestapp.dagger.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.github.anrimian.githubtestapp.dataset.Preferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 11.06.2017.
 */

@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @NonNull
    public Context provideAppContext() {
        return appContext;
    }

    @Provides
    @Singleton
    public Preferences providePreferences()  {
        return new Preferences(appContext);
    }
}
