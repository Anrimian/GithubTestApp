package com.github.anrimian.githubtestapp.features.screens.main.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.users.view.UsersResultListAdapter;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.AnimationUtils;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.recyclerview.endless.EndlessListScrollListener;
import com.github.anrimian.githubtestapp.utils.views.binders.ProgressViewBinder;
import com.github.anrimian.githubtestapp.utils.views.binders.SimpleProgressViewBinder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class UsersFragment extends MvpAppCompatFragment implements UsersView {

    @InjectPresenter
    UsersPresenter presenter;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private View footerView;

    private ProgressViewBinder progressViewBinder;
    private SimpleProgressViewBinder footerProgressViewBinder;

    private UsersResultListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.users);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new EndlessListScrollListener(presenter::isWaitForLoading, () -> presenter.startLoading(false)));

        swipeRefreshLayout.setOnRefreshListener(() -> presenter.startRefreshing());

        progressViewBinder = new ProgressViewBinder(view);
        progressViewBinder.setTryAgainButtonOnClickListener(v -> presenter.startLoading(true));

        footerView = View.inflate(getContext(), R.layout.partial_progress_state_simple, null);
        footerProgressViewBinder = new SimpleProgressViewBinder(footerView);
        footerProgressViewBinder.setTryAgainButtonOnClickListener(v -> presenter.startLoading(false));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search_users, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        String searchQuery = presenter.getSearchQuery();
        if (!TextUtils.isEmpty(searchQuery)) {
            searchItem.expandActionView();
            searchView.setQuery(searchQuery, false);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.startSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //presenter.startSearchWithDelay(newText);it notify when search view closed, first fix this
                return true;
            }
        });
        searchView.setOnSearchClickListener(v -> searchView.setQuery(presenter.getSearchQuery(), false));
    }

    @Override
    public void bindUsersList(List<UserSearchResult> results) {
        adapter = new UsersResultListAdapter(results);
        adapter.setOnItemClickListener(this::goToUserProfileScreen);
        adapter.addFooter(footerView);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showStartState() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);
        footerProgressViewBinder.hideAll();
        progressViewBinder.showMessage(R.string.time_to_search, false);
    }

    @Override
    public void showProgress(boolean refreshing, boolean empty) {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setEnabled(false);
        }
        if (empty && !refreshing) {
            progressViewBinder.showProgress();
            footerProgressViewBinder.hideAll();
        } else {
            if (empty) {
                progressViewBinder.showProgress();
                footerProgressViewBinder.hideAll();
            } else {
                progressViewBinder.hideAll();
                footerProgressViewBinder.showProgress();
            }
            if (refreshing) {
                swipeRefreshLayout.setRefreshing(true);
            }
        }
    }

    @Override
    public void showEmptyState() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);
        footerProgressViewBinder.hideAll();
        progressViewBinder.showMessage(R.string.users_not_found, false);
    }

    @Override
    public void showComplete() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);
        progressViewBinder.hideAll();
        footerProgressViewBinder.hideAll();
    }

    @Override
    public void showEndList() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);
        progressViewBinder.hideAll();
        footerProgressViewBinder.showMessage(R.string.no_more_searched_users, false);
    }

    @Override
    public void updateList(boolean animate) {
        adapter.notifyDataSetChanged();
        if (animate) {
            AnimationUtils.animateShowingList(recyclerView);
        }
    }

    @Override
    public void showStateError(ErrorInfo errorInfo) {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);

        String message = errorInfo.getMessage(getContext());
        progressViewBinder.showMessage(message, true);
        footerProgressViewBinder.hideAll();
    }

    @Override
    public void showMessageError(ErrorInfo errorInfo) {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);

        String message = errorInfo.getMessage(getContext());
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFooterStateMessage(ErrorInfo errorInfo) {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(false);

        String message = errorInfo.getMessage(getContext());
        footerProgressViewBinder.showMessage(message, true);
        progressViewBinder.hideAll();
    }

    private void goToUserProfileScreen(UserSearchResult userSearchResult) {

    }
}
