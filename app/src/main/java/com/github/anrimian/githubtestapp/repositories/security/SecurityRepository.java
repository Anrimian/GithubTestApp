package com.github.anrimian.githubtestapp.repositories.security;

import com.github.anrimian.githubtestapp.repositories.security.models.UserInfoModel;

import io.reactivex.Single;

/**
 * Created on 11.06.2017.
 */

public interface SecurityRepository {
    Single<UserInfoModel> signIn(String username, String password);
}
