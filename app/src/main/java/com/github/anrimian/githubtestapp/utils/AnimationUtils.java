package com.github.anrimian.githubtestapp.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;


/**
 * Created on 29.03.2017.
 */

public class AnimationUtils {

    public static void animateShowingList(RecyclerView recyclerView){
        Context ctx = recyclerView.getContext();
        Resources resources = ctx.getResources();
        int animationDuration = 300;
        float animationYOffset = 40;
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(recyclerView, View.ALPHA, 0, 1);
        alphaAnimator.setInterpolator(new DecelerateInterpolator());

        ObjectAnimator animator = ObjectAnimator.ofFloat(recyclerView, View.Y, animationYOffset, 0);
        animator.setInterpolator(new DecelerateInterpolator());

        AnimatorSet set = new AnimatorSet();
        set.setDuration(animationDuration);
        set.play(alphaAnimator).with(animator);
        set.start();
    }
}
