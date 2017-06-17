package com.github.anrimian.githubtestapp.features.screens.main.users.screens.user;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.moxy.SingleStateByTagStrategy;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface UserView extends MvpView {

    String LOADING_STATE = "loading_state";

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showProgress();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showError(ErrorInfo errorInfo);

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showProfile(UserInfoModel userInfoModel);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToRepoListScreen(String login);
}
