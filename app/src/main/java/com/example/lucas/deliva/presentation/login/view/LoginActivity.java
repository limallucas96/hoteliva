package com.example.lucas.deliva.presentation.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.login.presenter.LoginActivityView;
import com.example.lucas.deliva.presentation.order.view.OrderActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginActivityView {

    @BindView(R.id.login_text_input_layout)
    protected TextInputLayout mTextInputLayoutLogin;

    @BindView(R.id.login_edit_text)
    protected TextInputEditText mEmail;

    @BindView(R.id.login_password_text_input_layout)
    protected TextInputLayout mTextInputLayoutPassword;

    @BindView(R.id.password_edit_text)
    protected TextInputEditText mPassword;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void checkUser(){
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
        finish();
    }

    private void verifyFields(){
        String email = mEmail.getText().toString();
        if(email.isEmpty()){
            mTextInputLayoutLogin.setError(getString(R.string.login_empty_username));
            return;
        }

        String password = mPassword.getText().toString();
        if(password.isEmpty()){
            mTextInputLayoutPassword.setError(getString(R.string.login_empty_password));
            return;
        }

        checkUser();
    }

    @OnClick(R.id.login_enter) public void onLoginClick(View view){
        verifyFields();
    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void showLoginError() {

    }

}
