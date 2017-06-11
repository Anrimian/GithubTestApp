package com.github.anrimian.githubtestapp.repositories.security.models;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.auth.UserInfoResponse;

import org.mapstruct.Mapper;

/**
 * Created on 11.06.2017.
 */

@Mapper
public interface UserModelMapper {

    UserInfoModel mapUserInfoResponse(UserInfoResponse userInfoResponse);
}
