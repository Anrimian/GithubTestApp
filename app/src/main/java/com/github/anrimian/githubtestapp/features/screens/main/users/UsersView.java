package com.github.anrimian.githubtestapp.features.screens.main.users;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.moxy.SingleStateByTagStrategy;

import java.util.List;

/**
 * Created on 16.6.17. It is awesome java class.
 */

public interface UsersView extends MvpView {

    String LOADING_STATE = "loading_state";

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showStartState();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showProgress(boolean refreshing, boolean empty);

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showComplete();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showEmptyState();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showEndList();

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showFooterStateMessage(ErrorInfo errorInfo);

    @StateStrategyType(value = SingleStateByTagStrategy.class, tag = LOADING_STATE)
    void showStateError(ErrorInfo errorInfo);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void bindUsersList(List<UserSearchResult> results);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void updateList(boolean animate);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMessageError(ErrorInfo errorInfo);


}
