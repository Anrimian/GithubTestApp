package com.github.anrimian.githubtestapp.features.screens.main.users.screens.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.repo.RepoListActivity;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.views.binders.ProgressViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class UserActivity extends MvpAppCompatActivity implements UserView {

    public static final String LOGIN = "login";

    @InjectPresenter
    UserPresenter presenter;

    @BindView(R.id.profile_content_container)
    View profileContentContainer;

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;

    @BindView(R.id.tv_login)
    TextView tvLogin;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_company_title)
    TextView tvCompanyTitle;

    @BindView(R.id.tv_company)
    TextView tvCompany;

    @BindView(R.id.tv_email)
    TextView tvEmail;

    @BindView(R.id.tv_repo)
    TextView tvRepoCount;

    @BindView(R.id.btn_repositories)
    View btnRepos;

    private ProgressViewBinder progressViewBinder;

    @ProvidePresenter
    UserPresenter provideUserPresenter() {
        Intent intent = getIntent();
        String login = intent.getStringExtra(LOGIN);
        return new UserPresenter(login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_user_info, null);
        setContentView(view);
        ButterKnife.bind(this);

        Toolbar toolbar = ButterKnife.findById(view, R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setTitle(R.string.profile);

        progressViewBinder = new ProgressViewBinder(view);
        progressViewBinder.setTryAgainButtonOnClickListener(v -> presenter.loadProfileInfo());

        btnRepos.setOnClickListener(v -> presenter.goToRepoList());
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
    public void showProgress() {
        profileContentContainer.setVisibility(View.INVISIBLE);
        progressViewBinder.showProgress();
    }

    @Override
    public void showError(ErrorInfo errorInfo) {
        profileContentContainer.setVisibility(View.INVISIBLE);
        String message = errorInfo.getMessage(this);
        progressViewBinder.showMessage(message, true);
    }

    @Override
    public void showProfile(UserInfoModel userInfoModel) {
        profileContentContainer.setVisibility(View.VISIBLE);
        progressViewBinder.hideAll();

        Glide.with(this)
                .load(userInfoModel.getAvatar())
                .into(ivAvatar);

        tvLogin.setText(userInfoModel.getLogin());
        tvName.setText(userInfoModel.getName());

        String company = userInfoModel.getCompany();
        if (TextUtils.isEmpty(company)) {
            tvCompanyTitle.setVisibility(View.GONE);
            tvCompany.setVisibility(View.GONE);
        } else {
            tvCompanyTitle.setVisibility(View.VISIBLE);
            tvCompany.setVisibility(View.VISIBLE);
            tvCompany.setText(company);
        }
        String email = userInfoModel.getEmail();
        if (TextUtils.isEmpty(email)) {
            tvEmail.setVisibility(View.GONE);
        } else {
            tvEmail.setVisibility(View.VISIBLE);
            tvEmail.setText(email);
        }
        tvRepoCount.setText(String.valueOf(userInfoModel.getPublicRepoCount()));
    }

    @Override
    public void goToRepoListScreen(String login) {
        Intent intent = new Intent(this, RepoListActivity.class);
        intent.putExtra(RepoListActivity.USER_NAME, login);
        startActivity(intent);
    }
}
