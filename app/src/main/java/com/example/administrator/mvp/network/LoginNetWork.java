package com.example.administrator.mvp.network;


import android.os.AsyncTask;

import com.example.administrator.mvp.listener.ILoginListener;
import com.example.administrator.mvp.model.UserModle;

public class LoginNetWork implements ILoginNetWork {

    private MyAsyncTask myAsyncTask;

    @Override
    public void login(String userName, String passWord, ILoginListener loginListener) {
        // TODO Auto-generated method stub
        myAsyncTask = new MyAsyncTask(userName, passWord, loginListener);
        myAsyncTask.execute();
    }

    @Override
    public void removeRequest() {
        myAsyncTask.cancel(true);
        myAsyncTask = null;
    }

    private static class MyAsyncTask extends AsyncTask {
        String userName;
        String passWord;
        ILoginListener loginListener;

        public MyAsyncTask(String userName, String passWord, ILoginListener loginListener) {
            this.userName = userName;
            this.passWord = passWord;
            this.loginListener = loginListener;
        }

        @Override
        protected Object doInBackground(Object[] params) {
            try {
                //模拟耗时操作
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if ("name".equals(userName) && "123".equals(passWord)) {
                UserModle userModle = new UserModle();
                userModle.setUserName(userName);
                userModle.setPassWord(passWord);
                loginListener.loginSuccess(userModle);
            } else {
                loginListener.loginFail();
            }
        }
    }
}
