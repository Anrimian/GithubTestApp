package com.github.anrimian.githubtestapp.features.screens.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.DrawerFragment;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.views.binders.SimpleProgressViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 11.06.2017.
 */

public class SignInFragment extends MvpAppCompatFragment implements SignInView {

    @InjectPresenter
    SignInPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_login)
    EditText etLogin;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_sign_in)
    View btnSignIn;

    private SimpleProgressViewBinder progressViewBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, getActivity());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        getActivity().setTitle(R.string.sign_in);

        btnSignIn.setOnClickListener(v -> signIn());

        etLogin.setText("Anrimian");//TODO don't forget delete this
        etLogin.setOnEditorActionListener((v, actionId, event) -> {
            etPassword.requestFocus();
            return true;
        });

        etPassword.setOnEditorActionListener((v, actionId, event) -> {
            signIn();
            return true;
        });

        progressViewBinder = new SimpleProgressViewBinder(view);
        progressViewBinder.hideAll();
    }

    private void signIn() {
        presenter.signIn(etLogin.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showSuccess() {
        setViewsEnabled(false);
        progressViewBinder.showMessage(R.string.done, false);
    }

    @Override
    public void showProgress() {
        setViewsEnabled(false);
        progressViewBinder.showProgress();
    }

    @Override
    public void showError(ErrorInfo errorInfo) {
        String message = errorInfo.getMessage(getContext());
        setViewsEnabled(true);
        progressViewBinder.showMessage(message, false);
    }

    private void setViewsEnabled(boolean enabled) {
        etLogin.setEnabled(enabled);
        etPassword.setEnabled(enabled);
        btnSignIn.setEnabled(enabled);
    }

    @Override
    public void goToMainScreen() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, new DrawerFragment())
                .commit();
    }
}
