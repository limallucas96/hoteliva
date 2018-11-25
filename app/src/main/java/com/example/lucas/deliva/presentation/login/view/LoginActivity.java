package com.example.lucas.deliva.presentation.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.type.CountryType;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.login.dialog.CountrySelectorDialog;
import com.example.lucas.deliva.presentation.login.dialog.HostSettingsDialog;
import com.example.lucas.deliva.presentation.login.presenter.LoginPresenter;
import com.example.lucas.deliva.presentation.order.view.OrderActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.lucas.deliva.data.remote.WebServiceClient.BASE_URL;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.login_text_input_layout)
    protected TextInputLayout mTextInputLayoutLogin;

    @BindView(R.id.login_edit_text)
    protected TextInputEditText mEmail;

    @BindView(R.id.login_password_text_input_layout)
    protected TextInputLayout mTextInputLayoutPassword;

    @BindView(R.id.password_edit_text)
    protected TextInputEditText mPassword;

    @BindView(R.id.country_flag)
    protected ImageView mCountryFlag;

    private HostSettingsDialog mHostDialog;
    private String mHost;

    private CountrySelectorDialog mCountryDialog;

    @NonNull
    @Override
    protected LoginPresenter createPresenter(@NonNull Context context) {
        return new LoginPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCountryFlag(mPresenter.getLocaleFlag());
    }


    private void startOrderActivity() {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
        finish();
    }

    private void verifyFields() {
        String email = mEmail.getText().toString();
        if (email.isEmpty()) {
            mTextInputLayoutLogin.setError(getString(R.string.login_empty_username));
            return;
        }

        String password = mPassword.getText().toString();
        if (password.isEmpty()) {
            mTextInputLayoutPassword.setError(getString(R.string.login_empty_password));
            return;
        }

        mPresenter.login(email, password);
    }

    @OnClick(R.id.login_enter)
    public void onLoginClick(View view) {
        verifyFields();
    }

    @Override
    public void showLoginSuccess(@NonNull User user) {
        user.setLogged(true);
        mPresenter.setUser(user);
        startOrderActivity();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, "Não foi possivel fazer login", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.country_container)
    protected void onCountryContainerClick() {
        showCountrySelectorDialog();
    }

    private void showCountrySelectorDialog() {
        mCountryDialog = new CountrySelectorDialog(this, new CountrySelectorDialog.DialogListener() {
            @Override
            public void onConfirmClickListener(CountryType countryType) {
                mPresenter.persistLanguage(countryType);
                setCountryFlag(mPresenter.getLocaleFlag(countryType));
                mCountryDialog.dismiss();
            }
        });
        mCountryDialog.show();
    }

    private void setCountryFlag(Integer countryFlag) {
        mCountryFlag.setImageResource(countryFlag);
    }


    @Override
    public void restartActivity() {
        recreate();
    }

    @OnClick(R.id.container_ip)
    protected void onClickContainerIp() {
        showHostDialog();
    }

    private void showHostDialog() {
        mHostDialog = new HostSettingsDialog(getContext(), new HostSettingsDialog.DialogListener() {
            @Override
            public void onConfirmClickListener(String host) {
                mHost = host;
                mPresenter.setHost("http://" + mHost + ":5000");
//                BASE_URL = "http://" + mHost + ":5000";
                mHostDialog.dismiss();
            }
        });
        mHostDialog.show();
    }


}
