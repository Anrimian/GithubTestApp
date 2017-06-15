package com.github.anrimian.githubtestapp.utils.recyclerview.endless;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created on 18.11.2016.
 */

public class EndlessListScrollListener extends RecyclerView.OnScrollListener {


    private static final int DEFAULT_LOADING_OFFSET = 10;

    private int loadingOffset = DEFAULT_LOADING_OFFSET;
    private LoadingCallback loadingCallback;
    private LoadingFunction loadingFunction;

    public EndlessListScrollListener(LoadingCallback loadingCallback, LoadingFunction loadingFunction) {
        this.loadingCallback = loadingCallback;
        this.loadingFunction = loadingFunction;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        View child = recyclerView.getChildAt(recyclerView.getChildCount() - 1);

        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        int lastVisibleItemPosition = layoutManager.getPosition(child);

        if (lastVisibleItemPosition > totalItemCount - loadingOffset && loadingCallback.canLoad()) {
            loadingFunction.loadNextData();
        }
    }

    public void setLoadingOffset(int loadingOffset) {
        this.loadingOffset = loadingOffset;
    }
}
