package com.github.anrimian.githubtestapp.features.screens.main.users.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.repositories.users.UserRepository;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 16.6.17. It is awesome java class.
 */

public class UsersInteractorImpl implements UsersInteractor {

    @Inject
    UserRepository userRepository;

    public UsersInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<List<UserSearchResult>> loadUsers(String query, int page, int pageSize) {
        return userRepository.searchUsers(query, page, pageSize);
    }
}
