package com.github.anrimian.githubtestapp.features.screens.main.users.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.repositories.users.models.UserSearchResult;
import com.github.anrimian.githubtestapp.utils.recyclerview.adapter.HeaderFooterRecyclerViewAdapter;
import com.github.anrimian.githubtestapp.utils.recyclerview.adapter.OnItemClickListener;

import java.util.List;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class UsersResultListAdapter extends HeaderFooterRecyclerViewAdapter<UsersResultViewHolder> {

    private final List<UserSearchResult> repoList;

    private OnItemClickListener<UserSearchResult> onItemClickListener;

    public UsersResultListAdapter(List<UserSearchResult> repoList) {
        this.repoList = repoList;
    }

    @Override
    public UsersResultViewHolder createVH(ViewGroup viewGroup, int type) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_user_result, viewGroup, false);
        return new UsersResultViewHolder(v, onItemClickListener);
    }

    @Override
    public void bindVH(UsersResultViewHolder viewHolder, int position) {
        viewHolder.bind(repoList.get(position));
    }

    @Override
    public int getCount() {
        return repoList.size();
    }

    public void setOnItemClickListener(OnItemClickListener<UserSearchResult> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
