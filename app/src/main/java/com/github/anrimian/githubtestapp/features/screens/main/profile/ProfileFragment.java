package com.github.anrimian.githubtestapp.features.screens.main.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.user.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class ProfileFragment extends MvpAppCompatFragment implements ProfileView {

    @InjectPresenter
    ProfilePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.profile);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError(ErrorInfo errorInfo) {

    }

    @Override
    public void showProfile(UserInfoModel userInfoModel) {

    }
}
