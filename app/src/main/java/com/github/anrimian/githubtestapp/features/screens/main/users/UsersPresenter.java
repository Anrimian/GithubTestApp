package com.github.anrimian.githubtestapp.features.screens.main.users;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.main.users.business.UsersInteractor;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 16.6.17. It is awesome java class.
 */

@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    private static final int PAGE_SIZE = 20;

    private static final int SEARCH_DELAY = 250;

    @Inject
    UsersInteractor usersInteractor;

    private final List<UserSearchResult> searchResults = new ArrayList<>();

    private Disposable startSearchDisposable;
    private Disposable loadingDisposable;

    private String searchQuery;

    private boolean refreshing;

    public UsersPresenter() {
        Components.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().bindUsersList(searchResults);
    }

    void startLoading(boolean refresh) {
        getViewState().showProgress();
        refreshing = refresh;
        loadingDisposable = usersInteractor.loadUsers(searchQuery, 0, PAGE_SIZE)
                .subscribeOn(Schedulers.newThread())
                .observeOn((AndroidSchedulers.mainThread()))
                .subscribe(this::onLoadingCompete, this::onLoadingError);
    }

    private void onLoadingError(Throwable throwable) {
        ErrorInfo errorInfo = new ErrorInfo(throwable);
        getViewState().showError(errorInfo);
        refreshing = false;
    }

    private void onLoadingCompete(List<UserSearchResult> repos) {
        searchResults.addAll(repos);
        if (repos.isEmpty()) {
            getViewState().showError(new ErrorInfo(R.string.repo_not_found));
        } else {
            getViewState().showComplete();
            getViewState().updateList();
        }
        refreshing = false;
    }

    void startSearchWithDelay(String searchQuery) {
        if (startSearchDisposable != null) {
            startSearchDisposable.dispose();
        }
        startSearchDisposable = Observable.timer(SEARCH_DELAY, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> startSearch(searchQuery));
    }

    void startSearch(String searchQuery) {
        if (!TextUtils.isEmpty(searchQuery)) {
            this.searchQuery = searchQuery;
            if (loadingDisposable != null) {
                loadingDisposable.dispose();
            }
            searchResults.clear();
            getViewState().updateList();
            startLoading(true);
        }
    }
}
