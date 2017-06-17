package com.github.anrimian.githubtestapp.features.screens.main.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.bumptech.glide.Glide;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.EditProfileActivity;
import com.github.anrimian.githubtestapp.features.screens.main.repo.RepoListActivity;
import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.views.binders.ProgressViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class ProfileFragment extends MvpAppCompatFragment implements ProfileView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    ProfilePresenter presenter;

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

    @BindView(R.id.tv_gists)
    TextView tvGistsCount;

    @BindView(R.id.tv_private_repo)
    TextView tvPrivateRepoCount;

    @BindView(R.id.tv_owned_private_repo)
    TextView tvOwnedPrivateRepoCount;

    @BindView(R.id.btn_repositories)
    View btnRepos;

    private boolean showOptionsMenu = false;

    private ProgressViewBinder progressViewBinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.profile);
        ButterKnife.bind(this, view);

        progressViewBinder = new ProgressViewBinder(view);
        progressViewBinder.setTryAgainButtonOnClickListener(v -> presenter.loadProfileInfo());

        btnRepos.setOnClickListener(v -> presenter.goToRepoList());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (showOptionsMenu) {
            inflater.inflate(R.menu.profile_menu, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit_profile: {
                presenter.goToEditProfileScreen();
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProgress() {
        showOptionsMenu = false;
        getActivity().invalidateOptionsMenu();
        profileContentContainer.setVisibility(View.INVISIBLE);
        progressViewBinder.showProgress();
    }

    @Override
    public void showError(ErrorInfo errorInfo) {
        showOptionsMenu = false;
        getActivity().invalidateOptionsMenu();
        profileContentContainer.setVisibility(View.INVISIBLE);
        String message = errorInfo.getMessage(getContext());
        progressViewBinder.showMessage(message, true);
    }

    @Override
    public void showProfile(UserInfoModel userInfoModel) {
        showOptionsMenu = true;
        getActivity().invalidateOptionsMenu();
        profileContentContainer.setVisibility(View.VISIBLE);
        progressViewBinder.hideAll();

        Glide.with(getContext())
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
        tvGistsCount.setText(String.valueOf(userInfoModel.getPrivateGistsCount()));
        tvPrivateRepoCount.setText(String.valueOf(userInfoModel.getPrivateRepositoriesCount()));
        tvOwnedPrivateRepoCount.setText(String.valueOf(userInfoModel.getOwnedPrivateRepositoriesCount()));
    }

    @Override
    public void goToRepoListScreen(String login) {
        Intent intent = new Intent(getContext(), RepoListActivity.class);
        intent.putExtra(RepoListActivity.USER_NAME, login);
        startActivity(intent);
    }

    @Override
    public void goToEditProfileScreen(UserInfoModel userInfoModel) {
        Intent intent = new Intent(getContext(), EditProfileActivity.class);
        intent.putExtra(EditProfileActivity.USER_INFO, userInfoModel);
        startActivity(intent);
    }
}
