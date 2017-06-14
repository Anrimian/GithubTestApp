package com.github.anrimian.githubtestapp.repositories.repo;

import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;

import java.util.List;

import io.reactivex.Single;

/**
 * Created on 14.6.17. It is awesome java class.
 */

public interface RepoRepository {

    Single<List<RepoInfoModel>> getRepoInfoList(String userName, String token);
}
