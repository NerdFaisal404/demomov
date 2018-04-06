package com.faisal.retrofit_demo.base;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseDialog<V extends MvpView, P extends BasePresenter<V>> extends DialogFragment implements MvpView{
    private P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int viewId = getLayoutId();
        presenter = initPresenter();
        presenter.attachView((V)this);
        View view = inflater.inflate(viewId, container, false);
        startUi();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected abstract int getLayoutId();
    protected abstract P initPresenter();
    protected abstract void startUi();
}
