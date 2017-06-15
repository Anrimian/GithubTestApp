package com.github.anrimian.githubtestapp.utils.recyclerview.position;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

/**
 * Created on 17.04.2017.
 */

public class ListPositionUtils {

    @NonNull
    public static ListPosition getCurrentPosition(LinearLayoutManager layoutManager) {
        int index = layoutManager.findFirstVisibleItemPosition();
        View v = layoutManager.getChildAt(0);
        int top = (v == null) ? 0 : v.getTop();
        return new ListPosition(index, top);
    }

    public static void setCurrentPosition(LinearLayoutManager layoutManager, @Nullable ListPosition listPosition) {
        if (listPosition != null) {
            int index = listPosition.getIndex();
            int top = listPosition.getTop();
            layoutManager.scrollToPositionWithOffset(index, top);
        }
    }
}
