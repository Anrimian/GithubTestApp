package com.github.anrimian.githubtestapp.features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.features.screens.auth.SignInFragment;
import com.github.anrimian.githubtestapp.features.screens.main.DrawerFragment;

/**
 * Created on 11.06.2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToLoginScreen();
    }

    private void goToLoginScreen() {
        startFragment(new SignInFragment());
    }

    private void goToMainScreen() {
        startFragment(new DrawerFragment());
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, fragment)
                .commit();
    }
}
