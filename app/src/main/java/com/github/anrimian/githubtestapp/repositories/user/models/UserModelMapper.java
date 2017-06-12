package com.github.anrimian.githubtestapp.repositories.user.models;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.user.UserInfoResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created on 11.06.2017.
 */

@Mapper
public interface UserModelMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "login", source = "login"),
            @Mapping(target = "avatar", source = "avatar_url"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "company", source = "company"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "repositoriesUrl", source = "repos_url"),
            @Mapping(target = "privateGistsCount", source = "private_gists"),
            @Mapping(target = "privateRepositoriesCount", source = "total_private_repos"),
            @Mapping(target = "ownedPrivateRepositoriesCount", source = "owned_private_repos")
    })
    UserInfoModel mapUserInfoResponse(UserInfoResponse userInfoResponse);
}
