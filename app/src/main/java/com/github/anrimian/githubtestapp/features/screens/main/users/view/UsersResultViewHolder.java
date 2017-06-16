package com.github.anrimian.githubtestapp.features.screens.main.users.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.recyclerview.adapter.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 15.6.17. It is awesome java class.
 */

class UsersResultViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;

    @BindView(R.id.card_view)
    View cardView;

    private UserSearchResult user;

    UsersResultViewHolder(View itemView, OnItemClickListener<UserSearchResult> onItemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        if (onItemClickListener != null) {
            cardView.setOnClickListener(v -> onItemClickListener.onItemClick(user));
        }
    }

    void bind(UserSearchResult user) {
        this.user = user;
        bindLogin();
        bindAvatar();
    }

    private void bindLogin() {
        tvName.setText(user.getLogin());
    }

    private void bindAvatar() {
        Glide.with(getContext())
                .load(user.getAvatarUrl())
                .into(ivAvatar);
    }

    private Context getContext() {
        return itemView.getContext();
    }
}
