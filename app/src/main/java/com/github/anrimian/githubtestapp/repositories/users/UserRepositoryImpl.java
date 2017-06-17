package com.github.anrimian.githubtestapp.repositories.users;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.UsersApi;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.search.SearchUsersResultResponse;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.repositories.users.models.UserModelMapper;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;

import org.mapstruct.factory.Mappers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class UserRepositoryImpl implements UserRepository {

    @Inject
    UsersApi usersApi;

    private UserModelMapper userModelMapper = Mappers.getMapper(UserModelMapper.class);

    public UserRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<List<UserSearchResult>> searchUsers(String query, int page, int pageSize, String token) {
        return usersApi.searchUsers(query, page, pageSize, token)
                .map(SearchUsersResultResponse::getItems)
                .map(userModelMapper::mapUserSearchResponseList);
    }

    @Override
    public Single<UserInfoModel> getUserInfo(String login, String token) {
        return usersApi.getUserInfo(login, token)
                .map(userModelMapper::mapUserInfoResponse);
    }
}
