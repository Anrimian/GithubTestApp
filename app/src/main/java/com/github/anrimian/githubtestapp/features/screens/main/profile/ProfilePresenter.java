package com.github.anrimian.githubtestapp.features.screens.main.profile;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.main.profile.business.ProfileInteractor;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 13.6.17. It is awesome java class.
 */

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {

    @Inject
    ProfileInteractor interactor;

    private UserInfoModel userInfoModel;

    public ProfilePresenter() {
        Components.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadProfileInfo();
    }

    void loadProfileInfo() {
        getViewState().showProgress();
        interactor.getProfileInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onProfileLoaded, this::onProfileLoadingError);
    }

    private void onProfileLoadingError(Throwable throwable) {
        ErrorInfo errorInfo = new ErrorInfo(throwable);
        getViewState().showError(errorInfo);
    }

    private void onProfileLoaded(UserInfoModel userInfoModel) {
        this.userInfoModel = userInfoModel;
        getViewState().showProfile(userInfoModel);
    }

    void goToRepoList() {
        getViewState().goToRepoListScreen(userInfoModel.getLogin());
    }
}
