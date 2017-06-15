package com.github.anrimian.githubtestapp.repositories.preferences;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.preferences.Preferences;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;

import javax.inject.Inject;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class PreferencesRepositoryImpl implements PreferencesRepository {

    @Inject
    Preferences preferences;

    private String token;

    public PreferencesRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public void setToken(String token) {
        if (!TextUtils.equals(this.token, token)) {
            this.token = token;
            preferences.setToken(token);
        }
    }

    @Nullable
    @Override
    public String getToken() {
        if (token == null) {
            token = preferences.getToken();
        }
        return token;
    }

    @Override
    public boolean isUserLogined() {
        return getToken() != null;
    }

    @Override
    @Nullable
    public UserInfoModel getUserInfo() {
        return null;//TODO implement this
    }

    @Override
    public void setUserInfo(UserInfoModel userInfo) {
        /*preferences.setUserAvatar(userInfo.getAvatar());
        preferences.setCompanyuserInfo.getCompany();
        userInfo.getEmail();
        userInfo.getId();
        userInfo.getName();
        userInfo.getLogin();
        userInfo.getRepositoriesUrl();
        userInfo.getPrivateGistsCount();
        userInfo.getPrivateRepositoriesCount();
        userInfo.getOwnedPrivateRepositoriesCount();*///TODO implement this

    }
}
