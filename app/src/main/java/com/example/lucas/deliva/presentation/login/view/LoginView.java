package com.example.lucas.deliva.presentation.login.view;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.model.UserReturn;
import com.example.lucas.deliva.presentation.base.view.BaseView;

public interface LoginView extends BaseView {

    void showLoginSuccess(@NonNull final UserReturn user);

    void showLoginError();

    void restartActivity();

}
