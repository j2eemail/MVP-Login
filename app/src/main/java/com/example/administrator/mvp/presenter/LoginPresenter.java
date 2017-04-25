package com.example.administrator.mvp.presenter;

import com.example.administrator.mvp.listener.ILoginListener;
import com.example.administrator.mvp.model.UserModle;
import com.example.administrator.mvp.network.ILoginNetWork;
import com.example.administrator.mvp.network.LoginNetWork;
import com.example.administrator.mvp.view.ILoginView;

public class LoginPresenter extends BasePresenter<ILoginView> {

    private ILoginNetWork loginNetWork;

    public LoginPresenter(ILoginView loginView) {
        super(loginView);
        // TODO Auto-generated constructor stub
        loginNetWork = new LoginNetWork();
    }

    @Override
    public boolean isEmpty() {
        ILoginView loginView = getView();
        if (loginView.getUserName().isEmpty() || loginView.getPassWord().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void login() {
        // TODO Auto-generated method stub
        final ILoginView loginView = getView();
        if (isEmpty()) {
            loginView.isEmpty();
            return;
        }
        loginView.showLoading();
        loginNetWork.login(loginView.getUserName(), loginView.getPassWord(), new ILoginListener() {

            @Override
            public void loginSuccess(final UserModle userModle) {
                // TODO Auto-generated method stub
                loginView.loginSuccess(userModle);
                loginView.hideLoading();
            }

            @Override
            public void loginFail() {
                // TODO Auto-generated method stub
                loginView.loginFail();
                loginView.hideLoading();
            }
        });
    }

    @Override
    public void clearInput() {
        // TODO Auto-generated method stub
        ILoginView loginView = getView();
        loginView.clearUserName();
        loginView.clearPassword();
    }

    @Override
    public void clear() {
        loginNetWork.removeRequest();
        loginNetWork = null;
        super.clear();
    }

    @Override
    public ILoginView getView() {
        return (ILoginView) view;
    }
}
