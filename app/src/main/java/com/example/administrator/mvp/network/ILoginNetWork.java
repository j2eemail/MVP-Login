package com.example.administrator.mvp.network;

import com.example.administrator.mvp.listener.ILoginListener;

public interface ILoginNetWork {

	public void login(String userName, String passWord, ILoginListener loginListener);

	public void removeRequest();
}
