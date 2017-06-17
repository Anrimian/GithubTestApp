package com.github.anrimian.githubtestapp.features.screens.main.users;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
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

    private static final int START_PAGE = 1;
    private static final int PAGE_SIZE = 20;

    private static final int SEARCH_DELAY = 750;

    @Inject
    UsersInteractor usersInteractor;

    private final List<UserSearchResult> searchResults = new ArrayList<>();

    private Disposable startSearchDisposable;
    private Disposable loadingDisposable;

    private String searchQuery;

    private boolean refreshing;
    private boolean swipeRefreshing;
    private boolean waitForLoading = false;

    private int page = START_PAGE;

    public UsersPresenter() {
        Components.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().bindUsersList(searchResults);
        getViewState().showStartState();
    }

    void startRefreshing() {
        if (TextUtils.isEmpty(searchQuery)) {
            if (searchResults.isEmpty()) {
                getViewState().showStartState();
            } else {
                getViewState().showComplete();
            }
        } else {
            swipeRefreshing = true;
            startLoading(true);
        }
    }

    void startLoading(boolean refresh) {
        if (!TextUtils.isEmpty(searchQuery)) {
            waitForLoading = false;
            refreshing = refresh;
            getViewState().showProgress(swipeRefreshing, searchResults.isEmpty());
            loadingDisposable = usersInteractor.loadUsers(searchQuery, getCurrentPage(), PAGE_SIZE)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn((AndroidSchedulers.mainThread()))
                    .subscribe(this::onLoadingCompete, this::onLoadingError);
        }
    }

    private int getCurrentPage() {
        if (refreshing) {
            return START_PAGE;
        }
        return page;
    }

    private void onLoadingError(Throwable throwable) {
        ErrorInfo errorInfo = new ErrorInfo(throwable);
        if (searchResults.isEmpty()) {
            getViewState().showStateError(errorInfo);
        } else if (refreshing) {
            getViewState().showMessageError(errorInfo);
        } else {
            getViewState().showFooterStateMessage(errorInfo);
        }
        refreshing = false;
        swipeRefreshing = false;
    }

    private void onLoadingCompete(List<UserSearchResult> newResults) {
        if (refreshing) {
            searchResults.clear();
            page = START_PAGE;
        }

        boolean animate = searchResults.isEmpty() && !newResults.isEmpty();

        for (UserSearchResult result: newResults) {
            if (!searchResults.contains(result)) {
                searchResults.add(result);
            }
        }

        if (searchResults.isEmpty()) {
            getViewState().showEmptyState();
        } else {
            if (newResults.isEmpty()) {
                getViewState().showEndList();
            } else {
                page++;
                if (page == START_PAGE + 1) {
                    startLoading(false);
                } else {
                    waitForLoading = true;
                    getViewState().showComplete();
                }
            }
        }
        getViewState().updateList(animate);
        refreshing = false;
        swipeRefreshing = false;
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
        this.searchQuery = searchQuery;
        if (loadingDisposable != null) {
            loadingDisposable.dispose();
        }
        searchResults.clear();
        getViewState().updateList(false);

        if (TextUtils.isEmpty(searchQuery)) {
            getViewState().showStartState();
        } else {
            startLoading(true);
        }
    }

    String getSearchQuery() {
        return searchQuery;
    }

    boolean isWaitForLoading() {
        return waitForLoading;
    }
}
