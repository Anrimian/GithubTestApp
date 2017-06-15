package com.github.anrimian.githubtestapp.repositories.repo;

import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.dataset.retrofit.api.RepoApi;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoModelMapper;

import org.mapstruct.factory.Mappers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created on 14.6.17. It is awesome java class.
 */

public class RepoRepositoryImpl implements RepoRepository {

    @Inject
    RepoApi repoApi;

    private RepoModelMapper repoModelMapper = Mappers.getMapper(RepoModelMapper.class);

    public RepoRepositoryImpl() {
        Components.getAppComponent().inject(this);
    }

    @Override
    public Single<List<RepoInfoModel>> getRepoInfoList(String userName, String token) {
        return repoApi.getRepoList("token " + token, userName)
                .map(repoModelMapper::mapUserInfoResponseList);
    }
}
