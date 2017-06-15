package com.github.anrimian.githubtestapp.features.screens.main.repo.business;

import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;

import java.util.List;

import io.reactivex.Single;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface RepoListInteractor {

    Single<List<RepoInfoModel>> getRepoList(String userName);
}
