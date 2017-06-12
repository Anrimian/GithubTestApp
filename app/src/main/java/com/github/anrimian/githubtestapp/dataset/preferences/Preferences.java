package com.github.anrimian.githubtestapp.dataset.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

/**
 * Created on 11.06.2017.
 */

public class Preferences {

    private static final String PREFS_NAME = "app_preferences";
    private static final String TOKEN = "token";

    private SharedPreferences preferences;

    public Preferences(Context ctx) {
        preferences = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setToken(String token) {
        preferences.edit()
                .putString(TOKEN, token)
                .apply();
    }

    @Nullable
    public String getToken() {
        return preferences.getString(TOKEN, null);
    }
}
