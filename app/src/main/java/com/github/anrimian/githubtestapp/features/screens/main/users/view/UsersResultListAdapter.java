package com.github.anrimian.githubtestapp.features.screens.main.users.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.recyclerview.adapter.OnItemClickListener;

import java.util.List;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class UsersResultListAdapter extends RecyclerView.Adapter<UsersResultViewHolder> {

    private final List<UserSearchResult> repoList;

    private OnItemClickListener<UserSearchResult> onItemClickListener;

    public UsersResultListAdapter(List<UserSearchResult> repoList) {
        this.repoList = repoList;
    }

    @Override
    public UsersResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_user_result, parent, false);
        return new UsersResultViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(UsersResultViewHolder holder, int position) {
        holder.bind(repoList.get(position));
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public void setOnItemClickListener(OnItemClickListener<UserSearchResult> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
