package com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.moxy.SingleStateByTagStrategy;

/**
 * Created on 13.6.17. It is awesome java class.
 */

public interface EditProfileView extends MvpView {

    String SENDING_STATE = "sending_state";

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = SENDING_STATE)
    void showSendingProgress();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = SENDING_STATE)
    void showError(ErrorInfo errorInfo);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void displayEditInfo(UserInfoModel userInfoModel);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goBackToProfile();
}
