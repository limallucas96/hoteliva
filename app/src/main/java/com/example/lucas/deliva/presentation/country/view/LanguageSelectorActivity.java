package com.example.lucas.deliva.presentation.country.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.country.presenter.LanguageSelectorPresenter;
import com.example.lucas.deliva.presentation.login.view.LoginActivity;

import butterknife.OnClick;

public class LanguageSelectorActivity extends BaseActivity<LanguageSelectorPresenter> {

    @NonNull
    @Override
    protected LanguageSelectorPresenter createPresenter(@NonNull Context context) {
        return new LanguageSelectorPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_language_selector;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick({R.id.brazil_container, R.id.usa_container})
    protected void onCountryClick(View view) {
        switch (view.getId()) {
            case R.id.brazil_container:
                mPresenter.persistLanguage("pt", "BR");
                startLoginActivity();
                break;
            case R.id.usa_container:
                mPresenter.persistLanguage("en", "US");
                startLoginActivity();
                break;
        }
    }

    private void startLoginActivity() {
        Intent intent = new Intent(LanguageSelectorActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
