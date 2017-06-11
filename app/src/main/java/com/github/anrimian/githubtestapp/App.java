package com.github.anrimian.githubtestapp;

import android.app.Application;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.utils.acra.AcraReportDialog;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.config.ConfigurationBuilder;

/**
 * Created on 11.06.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Components.init(getApplicationContext());
        initAcra();
    }

    private void initAcra() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(this);
        //if (BuildConfig.DEBUG) {
            configurationBuilder
                    .setReportDialogClass(AcraReportDialog.class)
                    .setReportingInteractionMode(ReportingInteractionMode.DIALOG);
        //}
        ACRA.init(this, configurationBuilder);
    }
}
