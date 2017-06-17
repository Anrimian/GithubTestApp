package com.github.anrimian.githubtestapp.repositories.users;

import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;

import java.util.List;

import io.reactivex.Single;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public interface UserRepository {

    Single<List<UserSearchResult>> searchUsers(String query, int page, int pageSize, String token);

    Single<UserInfoModel> getUserInfo(String login, String token);
}
