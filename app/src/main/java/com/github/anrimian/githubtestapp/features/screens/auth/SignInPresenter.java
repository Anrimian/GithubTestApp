package com.github.anrimian.githubtestapp.features.screens.auth;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.auth.business.SignInInteractor;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 11.06.2017.
 */

@InjectViewState
public class SignInPresenter extends MvpPresenter<SignInView> {

    @Inject
    SignInInteractor inInteractor;

    public SignInPresenter() {
        Components.getAppComponent().inject(this);
    }

    void signIn(String login, String password) {
        getViewState().showProgress();
        inInteractor.signIn(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSignInSuccess, this::onSignInError);
    }

    private void onSignInError(Throwable throwable) {
        ErrorInfo errorInfo = new ErrorInfo(throwable);
        getViewState().showError(errorInfo);
    }

    private void onSignInSuccess() {
        getViewState().showSuccess();
        //getViewState().goToMainScreen();
    }
}
