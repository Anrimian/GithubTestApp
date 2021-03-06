package com.github.anrimian.githubtestapp.utils.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class HeaderFooterRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_ITEM = 0;

    private View header;
    private View footer;

    private boolean horizontal = false;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        if (type == TYPE_ITEM) {
            return createVH(viewGroup, type);
        } else {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (horizontal) {
                params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }
            frameLayout.setLayoutParams(params);
            if (type == TYPE_HEADER) {
                ViewGroup parent = (ViewGroup) header.getParent();
                if (parent != null) {
                    parent.removeView(header);
                }
                frameLayout.addView(header);
            } else {
                ViewGroup parent = (ViewGroup) footer.getParent();
                if (parent != null) {
                    parent.removeView(footer);
                }
                frameLayout.addView(footer);
            }
            return new HeaderFooterViewHolder(frameLayout);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder vh, int position) {
        if (!(position == 0 && hasHeader()) && !(position >= getCount() + (hasHeader() ? 1 : 0) && hasFooter())) {
            bindVH((T) vh, position - (hasHeader() ? 1 : 0));
        }
    }

    @Override
    public int getItemCount() {
        return getCount() + (hasHeader() ? 1 : 0) + (hasFooter() ? 1 : 0);
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public abstract T createVH(ViewGroup viewGroup, int type);

    public abstract void bindVH(final T viewHolder, int position);

    public abstract int getCount();

    private boolean hasHeader() {
        return header != null;
    }

    private boolean hasFooter() {
        return footer != null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && hasHeader()) {
            return TYPE_HEADER;
        } else if (position >= getCount() + (hasHeader() ? 1 : 0)) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    public void addHeader(View header) {
        this.header = header;
        notifyItemInserted(0);
    }

    public void removeHeader() {
        notifyItemRemoved(0);
        header = null;
    }

    public void addFooter(View footer) {
        this.footer = footer;
        notifyItemInserted(getItemCount());
    }

    public void removeFooter() {
        notifyItemRemoved(getItemCount());
        footer = null;
    }

    public View getHeader() {
        return header;
    }

    public View getFooter() {
        return footer;
    }

    public static class HeaderFooterViewHolder extends RecyclerView.ViewHolder {

        public HeaderFooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
