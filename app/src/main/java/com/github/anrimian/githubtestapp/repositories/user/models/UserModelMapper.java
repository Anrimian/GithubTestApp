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
            @Mapping(target = "avatar", source = "avatarUrl"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "company", source = "company"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "repositoriesUrl", source = "reposUrl"),
            @Mapping(target = "privateGistsCount", source = "privateGists"),
            @Mapping(target = "privateRepositoriesCount", source = "totalPrivateRepos"),
            @Mapping(target = "ownedPrivateRepositoriesCount", source = "ownedPrivateRepos"),
            @Mapping(target = "publicRepoCount", source = "publicRepos")
    })
    UserInfoModel mapUserInfoResponse(UserInfoResponse userInfoResponse);
}
