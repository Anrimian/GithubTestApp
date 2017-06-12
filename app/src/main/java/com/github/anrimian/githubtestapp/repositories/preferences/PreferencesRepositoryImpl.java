package com.github.anrimian.githubtestapp.repositories.preferences;

import android.support.annotation.Nullable;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.preferences.Preferences;
import com.github.anrimian.githubtestapp.repositories.user.models.UserInfoModel;

import javax.inject.Inject;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class PreferencesRepositoryImpl implements PreferencesRepository {

    @Inject
    Preferences preferences;

    public PreferencesRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public void setToken(String token) {
        preferences.setToken(token);
    }

    @Nullable
    @Override
    public String getToken() {
        return preferences.getToken();
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
