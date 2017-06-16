package com.github.anrimian.githubtestapp.features.screens.main.users.business;

import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;

import java.util.List;

import io.reactivex.Single;

/**
 * Created on 16.6.17. It is awesome java class.
 */

public interface UsersInteractor {
    Single<List<UserSearchResult>> loadUsers(String query, int page, int pageSize);
}
