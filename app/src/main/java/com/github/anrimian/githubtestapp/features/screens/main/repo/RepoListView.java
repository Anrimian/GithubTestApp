package com.github.anrimian.githubtestapp.features.screens.main.repo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.moxy.SingleStateByTagStrategy;

import java.util.List;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface RepoListView extends MvpView {

    String LOADING_STATE = "loading_state";

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showProgress();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showError(ErrorInfo errorInfo);

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showRepoList(List<RepoInfoModel> repos);
}
