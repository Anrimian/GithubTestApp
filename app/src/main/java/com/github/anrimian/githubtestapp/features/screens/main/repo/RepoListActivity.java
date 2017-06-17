package com.github.anrimian.githubtestapp.features.screens.main.repo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.repo.view.RepoListAdapter;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.views.binders.ProgressViewBinder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class RepoListActivity extends MvpAppCompatActivity implements RepoListView {

    public static final String USER_NAME = "user_name";

    @InjectPresenter
    RepoListPresenter presenter;

    @ProvidePresenter
    RepoListPresenter providePresenter() {
        Intent intent = getIntent();
        String userName = intent.getStringExtra(USER_NAME);
        return new RepoListPresenter(userName);
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ProgressViewBinder progressViewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_repo_list, null);
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        progressViewBinder = new ProgressViewBinder(view);
        progressViewBinder.setTryAgainButtonOnClickListener(v -> presenter.loadRepoList());
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
        progressViewBinder.showProgress();
    }

    @Override
    public void showError(ErrorInfo errorInfo) {
        String message = errorInfo.getMessage(this);
        progressViewBinder.showMessage(message, true);
    }

    @Override
    public void showRepoList(List<RepoInfoModel> repos) {
        progressViewBinder.hideAll();

        RepoListAdapter repoListAdapter = new RepoListAdapter(repos);
        repoListAdapter.setOnItemClickListener(this::goToRepoScreen);
        recyclerView.setAdapter(repoListAdapter);
    }

    @Override
    public void showEmptyState() {
        progressViewBinder.showMessage(R.string.no_repo, false);
    }

    private void goToRepoScreen(RepoInfoModel repoInfoModel) {
        String url = repoInfoModel.getHtmlUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


}
