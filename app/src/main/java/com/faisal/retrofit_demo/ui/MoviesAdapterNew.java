/*
package com.faisal.retrofit_demo.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faisal.retrofit_demo.R;
import com.faisal.retrofit_demo.base.BaseAdapter;
import com.faisal.retrofit_demo.base.BaseViewHolder;
import com.faisal.retrofit_demo.data.local.movie.Movie;

import java.util.List;

public class MoviesAdapterNew extends BaseAdapter<Movie> {
    private Context mContext;
    private List<Movie> movies;
    private int rowLayout;


    private final int ITEM_TYPE_HEADER = 1;
    private final int ITEM_TYPE_CONTENT = 2;
    public static final String UNKNOWN_HEADER = "ukh";
    public static final String KNOWN_HEADER = "knh";

    public MoviesAdapterNew(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }


    public void remove(Movie user) {
        List<Movie> userList = getItems();
        for (int i = 0; i < userList.size(); i++) {
            if (user.getId().equals(userList.get(i).getId())) {
                userList.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }




    @Override
    public boolean isEqual(Movie left, Movie right) {
        return left.getId().equals(right.getId());
    }

    @Override
    public BaseViewHolder newViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolderNew(view);
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    private class MovieViewHolderNew extends BaseViewHolder<Movie> implements View.OnClickListener {
      //  private final ItemInRangeContentBinding binding;

        public MovieViewHolderNew(ItemInRangeContentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.contactLayout.setOnClickListener(this);
            binding.statusViewLayout.setOnClickListener(this);
        }

        @Override
        public void bind(Movie item) {
            binding.setUser(item);
            binding.executePendingBindings();

            UserState userState = UserState.on().getUserState(item.getPeerId());

            binding.inRangeTxt.setText(userState.getText());
            binding.inRangeTxt.setBackgroundResource(userState.getBackgroundResource());
            binding.contactImage.setBorderColor(userState.getBorderColor());


        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(view, getItem(getAdapterPosition()));
        }
    }
    @Override
    protected Movie getObjForPosition(int position) {
        return null;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return 0;
    }
}

*/
