package com.github.anrimian.githubtestapp.features.screens.main.repo.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.repo.models.RepoInfoModel;
import com.github.anrimian.githubtestapp.utils.recyclerview.adapter.OnItemClickListener;

import java.util.List;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class RepoListAdapter extends RecyclerView.Adapter<RepoViewHolder> {

    private final List<RepoInfoModel> repoList;

    private OnItemClickListener<RepoInfoModel> onItemClickListener;

    public RepoListAdapter(List<RepoInfoModel> repoList) {
        this.repoList = repoList;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bind(repoList.get(position));
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public void setOnItemClickListener(OnItemClickListener<RepoInfoModel> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
