package com.github.anrimian.githubtestapp.dataset;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created on 11.06.2017.
 */

public class Preferences {

    private static final String PREFS_NAME = "app_preferences";

    private SharedPreferences preferences;

    public Preferences(Context ctx) {
        preferences = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
}
