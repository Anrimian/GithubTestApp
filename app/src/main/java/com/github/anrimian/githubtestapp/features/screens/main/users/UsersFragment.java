package com.github.anrimian.githubtestapp.features.screens.main.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.users.view.UsersResultListAdapter;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.errors.ErrorInfo;
import com.github.anrimian.githubtestapp.utils.views.binders.ProgressViewBinder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 12.6.17. It is awesome java class.
 */

public class UsersFragment extends MvpAppCompatFragment implements UsersView{

    @InjectPresenter
    UsersPresenter presenter;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ProgressViewBinder progressViewBinder;

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

        progressViewBinder = new ProgressViewBinder(view);
        progressViewBinder.setTryAgainButtonOnClickListener(v -> presenter.startLoading(true));
        progressViewBinder.showMessage(R.string.time_to_search, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search_users, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.startSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.startSearchWithDelay(newText);
                return true;
            }
        });
    }

    @Override
    public void bindUsersList(List<UserSearchResult> results) {
        adapter = new UsersResultListAdapter(results);
        adapter.setOnItemClickListener(this::goToUserProfileScreen);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        progressViewBinder.showProgress();
    }

    @Override
    public void showError(ErrorInfo errorInfo) {
        String error = errorInfo.getMessage(getContext());
        progressViewBinder.showMessage(error, true);
    }

    @Override
    public void showComplete() {
        progressViewBinder.hideAll();
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }

    private void goToUserProfileScreen(UserSearchResult userSearchResult) {

    }
}
