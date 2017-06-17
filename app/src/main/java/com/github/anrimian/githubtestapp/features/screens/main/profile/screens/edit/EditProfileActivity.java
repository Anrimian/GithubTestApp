package com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.views.binders.SimpleProgressViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class EditProfileActivity extends MvpAppCompatActivity implements EditProfileView {

    public static final String USER_INFO = "user_info";

    @InjectPresenter
    EditProfilePresenter presenter;

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_company)
    EditText etCompany;

    @BindView(R.id.btn_submit)
    View btnSubmit;

    private SimpleProgressViewBinder progressViewBinder;

    @ProvidePresenter
    EditProfilePresenter providePresenter() {
        Intent intent = getIntent();
        UserInfoModel userInfoModel = (UserInfoModel) intent.getSerializableExtra(USER_INFO);
        return new EditProfilePresenter(userInfoModel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_edit_profile, null);
        setContentView(view);
        ButterKnife.bind(this);
        setTitle(null);

        Toolbar toolbar = ButterKnife.findById(view, R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnSubmit.setOnClickListener(v -> presenter.changeProfileInfo(etName.getText().toString(),
                etEmail.getText().toString(),
                etCompany.getText().toString()));

        progressViewBinder = new SimpleProgressViewBinder(view);
        progressViewBinder.hideAll();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void displayEditInfo(UserInfoModel userInfoModel) {
        etName.setText(userInfoModel.getName());
        etEmail.setText(userInfoModel.getEmail());
        etCompany.setText(userInfoModel.getCompany());
    }

    @Override
    public void showSendingProgress() {
        setViewsEnabled(false);
        progressViewBinder.showProgress();
    }

    @Override
    public void showError(ErrorInfo errorInfo) {
        setViewsEnabled(true);
        String message = errorInfo.getMessage(this);
        progressViewBinder.showMessage(message, false);
    }

    private void setViewsEnabled(boolean enabled) {
        etName.setEnabled(enabled);
        etEmail.setEnabled(enabled);
        etCompany.setEnabled(enabled);
        btnSubmit.setEnabled(enabled);
    }

    @Override
    public void goBackToProfile() {
        finish();
    }
}
