package com.github.anrimian.githubtestapp.features;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.anrimian.githubtestapp.R;

/**
 * Created on 11.06.2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
