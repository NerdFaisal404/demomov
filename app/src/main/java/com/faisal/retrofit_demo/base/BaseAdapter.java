package com.faisal.retrofit_demo.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {
    private final List<T> mItemList;
    protected ItemClickListener itemClickListener;
    protected ItemLongClickListener itemLongClickListener;

    public BaseAdapter() {
        mItemList = new ArrayList<T>();
    }

    public abstract boolean isEqual(T left, T right);

    public abstract BaseViewHolder newViewHolder(ViewGroup parent, int viewType);

    protected abstract int getLayoutIdForPosition(int position);

    protected abstract T getObjForPosition(int position);

    public void setItemLongClickListener(ItemLongClickListener itemLongClickListener){
        this.itemLongClickListener = itemLongClickListener;
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return newViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        T itemData = getItem(position);
        holder.bind(itemData);
    }

    public void clear() {
        mItemList.clear();
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return mItemList;
    }

    public void removeItem(T t) {
        int toIndex = mItemList.indexOf(t);
        if (toIndex < 0 || toIndex >= mItemList.size()) return;
        mItemList.remove(toIndex);
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        if (position < 0 || position >= mItemList.size()) return null;
        return mItemList.get(position);
    }

   /* public void addItem(T item) {

        int position = 0;
        addItem(item, position);

    }*/

    public int addItem(T item) {

        T tItem = findItem(item);

        if (tItem == null) {
            mItemList.add(item);
            notifyItemInserted(mItemList.size() - 1);
            return mItemList.size() - 1 ;
        }
        return updateItem(item, tItem);
    }

    public void addItem(List<T> items) {
        for (T item : items) {
            addItem(item);
        }
    }

    public void addItemToPosition(T item, int position) {
        mItemList.add(position, item);
        notifyItemInserted(position);
    }

    public T findItem(T item) {
        for (T tItem : mItemList) {
            if (isEqual(item, tItem)) {
                return tItem;
            }
        }
        return null;
    }

    public void addItems(List<T> items) {
        for (T item : items) {
            addItem(item);
        }
    }

    public int updateItem(T fromItem, T toItem) {
        int toIndex = mItemList.indexOf(toItem);
        mItemList.set(toIndex, fromItem);
        notifyItemChanged(toIndex);
        return toIndex;
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
