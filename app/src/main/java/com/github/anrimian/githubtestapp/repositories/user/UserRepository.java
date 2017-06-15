package com.github.anrimian.githubtestapp.repositories.user;

import com.github.anrimian.githubtestapp.repositories.user.models.UserInfoModel;
import com.github.anrimian.githubtestapp.repositories.user.models.UserSearchResult;

import java.util.List;

import io.reactivex.Single;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public interface UserRepository {

    Single<UserInfoModel> getUserInfo(String token);

    Single<List<UserSearchResult>> searchUsers(String query, int page);
}
