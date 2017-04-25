package com.example.administrator.mvp.presenter;


import android.os.Handler;

import com.example.administrator.mvp.view.IView;

public abstract class BasePresenter<T> implements IPresenter {

    public IView view;

    public BasePresenter(IView view) {
        this.view = view;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        view = null;
    }

    public abstract T getView();

    public abstract void login();

    public abstract void clearInput();
}
