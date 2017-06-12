package com.github.anrimian.githubtestapp.features.screens.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.main.profile.ProfileFragment;
import com.github.anrimian.githubtestapp.features.screens.main.users.UsersFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 11.06.2017.
 */

public class DrawerFragment extends MvpAppCompatFragment {

    private static final int NO_ITEM_TO_START = -1;

    @BindView(R.id.drawer)
    DrawerLayout drawer;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle drawerToggle;

    private int selectedDrawerItemId = -1;
    private int itemIdToStart = NO_ITEM_TO_START;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        ButterKnife.bind(this, view);

        Toolbar toolbar = ButterKnife.findById(view, R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (selectedDrawerItemId != itemId) {
                selectedDrawerItemId = itemId;
                itemIdToStart = itemId;
                clearFragment();
            }
            drawer.closeDrawer(Gravity.START);
            return true;
        });

        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawer, R.string.open_drawer, R.string.close_drawer);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (itemIdToStart != NO_ITEM_TO_START) {
                    switch (itemIdToStart) {
                        case R.id.menu_profile: {
                            startFragment(new ProfileFragment());
                            break;
                        }
                        case R.id.menu_users: {
                            startFragment(new UsersFragment());
                            break;
                        }
                    }
                    itemIdToStart = NO_ITEM_TO_START;
                }
            }
        });

        Fragment currentFragment = getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.drawer_fragment_container);
        if (currentFragment == null) {
            setupStartFragment();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean toggleSelected = drawerToggle.onOptionsItemSelected(item);
        return toggleSelected || super.onOptionsItemSelected(item);
    }

    private void setupStartFragment() {
        selectedDrawerItemId = R.id.menu_profile;
        navigationView.setCheckedItem(selectedDrawerItemId);
        startFragment(new ProfileFragment());
    }

    private void startFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.alpha_appear_animation, R.anim.alpha_disappear_animation)
                .replace(R.id.drawer_fragment_container, fragment)
                .commit();
    }

    private void clearFragment() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Fragment currentFragment = fm.findFragmentById(R.id.drawer_fragment_container);
        if (currentFragment != null) {
            fm.beginTransaction()
                    .remove(currentFragment)
                    .commit();
        }
    }
}
