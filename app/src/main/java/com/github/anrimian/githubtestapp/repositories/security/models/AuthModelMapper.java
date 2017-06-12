package com.github.anrimian.githubtestapp.repositories.security.models;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth.AuthResponse;

import org.mapstruct.Mapper;

/**
 * Created on 12.6.17. It is awesome java class.
 */

@Mapper
public interface AuthModelMapper {

    AuthorizationInfo mapAuthResponse(AuthResponse authResponse);
}
