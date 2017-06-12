package com.github.anrimian.githubtestapp.repositories.security;

import com.github.anrimian.githubtestapp.repositories.security.models.AuthorizationInfo;

import io.reactivex.Single;

/**
 * Created on 11.06.2017.
 */

public interface SecurityRepository {
    Single<AuthorizationInfo> signIn(String username, String password);
}
