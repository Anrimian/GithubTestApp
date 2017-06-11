package com.github.anrimian.githubtestapp.dagger;


import android.content.Context;

import com.github.anrimian.githubtestapp.dagger.components.AppComponent;
import com.github.anrimian.githubtestapp.dagger.components.DaggerAppComponent;
import com.github.anrimian.githubtestapp.dagger.modules.AppModule;


/**
 * Created on 11.02.2017.
 */

public class Components {

    private static Components instance;

    private AppComponent appComponent;

    public static void init(Context appContext) {
        instance = new Components(appContext);
    }

    private static Components getInstance() {
        if (instance == null) {
            throw new IllegalStateException("components must be init first");
        }
        return instance;
    }

    private Components(Context appContext) {
        appComponent = buildAppComponent(appContext);
    }

    private AppComponent buildAppComponent(Context appContext) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();
    }

    public static AppComponent getAppComponent() {
        return getInstance().appComponent;
    }

}
