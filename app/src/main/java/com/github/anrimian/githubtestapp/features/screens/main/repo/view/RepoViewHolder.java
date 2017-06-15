package com.github.anrimian.githubtestapp.features.screens.main.repo.view;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;
import com.github.anrimian.githubtestapp.utils.recyclerview.adapter.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 15.6.17. It is awesome java class.
 */

class RepoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_description_title)
    TextView tvDescriptionTitle;

    private RepoInfoModel repoInfoModel;

    RepoViewHolder(View itemView, OnItemClickListener<RepoInfoModel> onItemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        if (onItemClickListener != null) {
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(repoInfoModel));
        }
    }

    void bind(RepoInfoModel repoInfoModel) {
        this.repoInfoModel = repoInfoModel;
        bindName();
        bindDescription();
    }

    private void bindName() {
        tvName.setText(repoInfoModel.getName());
    }

    private void bindDescription() {
        String description = repoInfoModel.getDescription();
        if (TextUtils.isEmpty(description)) {
            tvDescriptionTitle.setVisibility(View.GONE);
            tvDescription.setVisibility(View.GONE);
        } else {
            tvDescriptionTitle.setVisibility(View.VISIBLE);
            tvDescription.setVisibility(View.VISIBLE);
            tvDescription.setText(description);
        }
    }
}
