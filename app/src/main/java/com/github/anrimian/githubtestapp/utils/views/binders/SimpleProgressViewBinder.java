package com.github.anrimian.githubtestapp.utils.views.binders;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.anrimian.githubtestapp.R;


/**
 * Created on 21.02.2016.
 */
public class SimpleProgressViewBinder {

    private ProgressBar progressBar;
    private TextView tvMessage;
    private View btnTryAgain;

    public SimpleProgressViewBinder(View view) {
        progressBar = (ProgressBar) view.findViewById(R.id.psv_progress_bar);
        tvMessage = (TextView) view.findViewById(R.id.psv_tv_message);
        btnTryAgain = view.findViewById(R.id.psv_btn_action);
    }

    public SimpleProgressViewBinder(ProgressBar progressBar, TextView tvMessage, View btnTryAgain) {
        this.progressBar = progressBar;
        this.tvMessage = tvMessage;
        this.btnTryAgain = btnTryAgain;
    }

    public void setTryAgainButtonOnClickListener(View.OnClickListener listener) {
        btnTryAgain.setOnClickListener(listener);
    }

    public void hideAll() {
        progressBar.setVisibility(View.INVISIBLE);
        tvMessage.setVisibility(View.INVISIBLE);
        btnTryAgain.setVisibility(View.INVISIBLE);
    }

    public void goneAll() {
        progressBar.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
        btnTryAgain.setVisibility(View.GONE);
    }

    public void showMessage(int messageId, boolean showTryAgainButton) {
        String message = progressBar.getContext().getString(messageId);
        showMessage(message, showTryAgainButton);
    }

    public void showMessage(String message, boolean showTryAgainButton) {
        progressBar.setVisibility(View.INVISIBLE);
        tvMessage.setVisibility(View.VISIBLE);
        if (message != null) {
            tvMessage.setText(message);
        }
        if (showTryAgainButton) {
            btnTryAgain.setVisibility(View.VISIBLE);
        } else {
            btnTryAgain.setVisibility(View.GONE);
        }
    }

    public void showProgress() {
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.INVISIBLE);
        btnTryAgain.setVisibility(View.INVISIBLE);
    }
}
