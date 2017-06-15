package com.github.anrimian.githubtestapp.features.screens.main.profile;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.moxy.AddToEndSingleByTagStateStrategy;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface ProfileView extends MvpView {

    String LOADING_STATE = "loading_state";

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy.class, tag = LOADING_STATE)
    void showProgress();

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy.class, tag = LOADING_STATE)
    void showError(ErrorInfo errorInfo);

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy.class, tag = LOADING_STATE)
    void showProfile(UserInfoModel userInfoModel);
}
