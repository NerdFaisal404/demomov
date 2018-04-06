package com.faisal.retrofit_demo.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faisal.retrofit_demo.R;

public class FragmentDetail extends Fragment {

    public FragmentDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }



}