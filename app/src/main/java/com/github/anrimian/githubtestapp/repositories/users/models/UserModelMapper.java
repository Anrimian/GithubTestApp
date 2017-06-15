package com.github.anrimian.githubtestapp.repositories.users.models;

import com.github.anrimian.githubtestapp.dataset.retrofit.requests.UpdateProfileRequest;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.search.UserSearchInfoResponse;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.user.UserInfoResponse;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

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

    UserSearchResult mapUserSearchResponseList(UserSearchInfoResponse response);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<UserSearchResult> mapUserSearchResponseList(List<UserSearchInfoResponse> response);

    UpdateProfileRequest mapUserInfoToUpdateRequest(UserInfoModel userInfoModel);
}
