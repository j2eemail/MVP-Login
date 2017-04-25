package com.example.administrator.mvp.view;

import com.example.administrator.mvp.model.UserModle;

public interface ILoginView extends IView {

    String getUserName();

    String getPassWord();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void isEmpty();

    void loginSuccess(UserModle userModle);

    void loginFail();

}
