package com.faisal.retrofit_demo.base;




import android.view.View;

public interface ItemLongClickListener<T> {
    void onItemLongClick(View v, T item);
}
