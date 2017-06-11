package com.github.anrimian.githubtestapp.features.screens.auth;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.moxy.AddToEndSingleByTagStateStrategy;

/**
 * Created on 11.06.2017.
 */

public interface SignInView extends MvpView {

    String AUTH_STATE = "auth_state";

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy.class, tag = AUTH_STATE)
    void showSuccess();

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy.class, tag = AUTH_STATE)
    void showProgress();

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy.class, tag = AUTH_STATE)
    void showError(ErrorInfo errorInfo);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();
}
