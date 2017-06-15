package com.github.anrimian.githubtestapp.features.screens.main.repo.business;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.repositories.preferences.PreferencesRepository;
import com.github.anrimian.githubtestapp.repositories.repo.RepoRepository;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public class RepoListInteractorImpl implements RepoListInteractor {

    @Inject
    RepoRepository repoRepository;

    @Inject
    PreferencesRepository preferencesRepository;

    public RepoListInteractorImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<List<RepoInfoModel>> getRepoList(String userName) {
        return repoRepository.getRepoInfoList(userName, preferencesRepository.getToken());
    }
}
