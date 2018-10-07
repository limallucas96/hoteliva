package com.example.lucas.deliva.presentation.base.view.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<V, K extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<K> {


    protected final List<V> mData = new ArrayList<>();

    protected OnItemClickListener<V> mOnItemClickListener;

    @Override
    public abstract K onCreateViewHolder(ViewGroup viewGroup, int viewType);

    @Override
    public abstract void onBindViewHolder(K k, int position);

    public abstract boolean validateDate();

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public List<V> getData() {
        return mData;
    }

    public void setOnItemClickListener(@Nullable final OnItemClickListener<V> listener) {
        mOnItemClickListener = listener;
    }

    public void addEntity(@NonNull final V entity) {
        mData.add(entity);
        notifyItemInserted(mData.size() - 1);
    }

    public void deleteEntity(final int i) {
        mData.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, getItemCount());
    }

    private void moveEntity(final int i, final int loc) {
        move(mData, i, loc);
        notifyItemMoved(i, loc);
    }

    private void move(List<V> data, int a, int b) {
        V temp = data.remove(a);
        data.add(b, temp);
    }

    public void setData(final List<V> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    private int getLocation(List<V> data, V entity) {
        for (int j = 0; j < data.size(); ++j) {
            V newEntity = data.get(j);
            if (entity.equals(newEntity)) {
                return j;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return mData.isEmpty();
    }

    public interface OnItemClickListener<V> {
        void onItemClickListener(@NonNull View view, @NonNull final V item);
    }
}
