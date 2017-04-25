package com.example.administrator.mvp.listener;


import com.example.administrator.mvp.model.UserModle;

public interface ILoginListener {

	void loginSuccess(UserModle userModle);

	void loginFail();

}
