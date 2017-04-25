package com.example.administrator.mvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvp.model.UserModle;
import com.example.administrator.mvp.presenter.LoginPresenter;
import com.example.administrator.mvp.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private LoginPresenter loginPresenter;
    private ProgressDialog dialog;
    private EditText view_username;
    private EditText view_password;
    private Button view_login;
    private Button view_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        loginPresenter = new LoginPresenter(this);

        view_username = (EditText) findViewById(R.id.view_username);
        view_password = (EditText) findViewById(R.id.view_password);
        view_login = (Button) findViewById(R.id.view_login);
        view_clear = (Button) findViewById(R.id.view_clear);

        view_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (loginPresenter != null) {
                    loginPresenter.login();
                }
            }
        });

        view_clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (loginPresenter != null) {
                    loginPresenter.clearInput();
                }
            }
        });

    }

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return view_username.getText().toString();
    }

    @Override
    public String getPassWord() {
        // TODO Auto-generated method stub
        return view_password.getText().toString();
    }

    @Override
    public void clearUserName() {
        // TODO Auto-generated method stub
        view_username.setText("");
    }

    @Override
    public void clearPassword() {
        // TODO Auto-generated method stub
        view_password.setText("");
    }

    @Override
    public void showLoading() {
        // TODO Auto-generated method stub
        dialog.show();
    }

    @Override
    public void hideLoading() {
        // TODO Auto-generated method stub
        dialog.dismiss();
    }

    @Override
    public void isEmpty() {
        // TODO Auto-generated method stub
        show("请输入用户名和密码！");
    }

    @Override
    public void loginSuccess(UserModle userBean) {
        // TODO Auto-generated method stub
        show("登陆成功！");
    }

    @Override
    public void loginFail() {
        // TODO Auto-generated method stub
        show("登陆失败！");
    }

    private void show(String str) {
        Log.d("CESHI", str);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginPresenter.clear();
        loginPresenter = null;
    }

}
