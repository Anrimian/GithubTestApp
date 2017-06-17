package com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.anrimian.githubtestapp.dagger.Components;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business.EditProfileInteractor;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 13.6.17. It is awesome java class.
 */

@InjectViewState
public class EditProfilePresenter extends MvpPresenter<EditProfileView> {

    @Inject
    EditProfileInteractor interactor;

    private UserInfoModel userInfoModel;

    public EditProfilePresenter(UserInfoModel userInfoModel) {
        Components.getAppComponent().inject(this);
        this.userInfoModel = userInfoModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().displayEditInfo(userInfoModel);
    }

    void changeProfileInfo(String name, String email, String company) {
        getViewState().showSendingProgress();
        userInfoModel.setName(name);
        userInfoModel.setEmail(email);
        userInfoModel.setCompany(company);
        interactor.changeProfileInfo(userInfoModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onProfileInfoChanged, this::onChangingError);
    }

    private void onChangingError(Throwable throwable) {
        ErrorInfo errorInfo = new ErrorInfo(throwable);
        getViewState().showError(errorInfo);
    }

    private void onProfileInfoChanged() {
        getViewState().goBackToProfile();
    }
}
