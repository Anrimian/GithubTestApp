package com.github.anrimian.githubtestapp.features.screens.main.repo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.main.repo.business.RepoListInteractor;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 13.6.17. It is awesome java class.
 */

@InjectViewState
public class RepoListPresenter extends MvpPresenter<RepoListView> {

    @Inject
    RepoListInteractor interactor;

    private String userName;

    public RepoListPresenter(String userName) {
        Components.getAppComponent().inject(this);
        this.userName = userName;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadRepoList();
    }

    void loadRepoList() {
        getViewState().showProgress();
        interactor.getRepoList(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onRepoListLoaded, this::onRepoListLoadingError);
    }

    private void onRepoListLoadingError(Throwable throwable) {
        ErrorInfo errorInfo = new ErrorInfo(throwable);
        getViewState().showError(errorInfo);
    }

    private void onRepoListLoaded(List<RepoInfoModel> repos) {
        getViewState().showRepoList(repos);
    }
}
