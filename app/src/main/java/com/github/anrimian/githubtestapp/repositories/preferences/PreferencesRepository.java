package com.github.anrimian.githubtestapp.repositories.preferences;

import android.support.annotation.Nullable;

import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public interface PreferencesRepository {
    void setToken(String token);

    @Nullable
    String getToken();

    boolean isUserLogined();

    UserInfoModel getUserInfo();

    void setUserInfo(UserInfoModel userInfo);
}
