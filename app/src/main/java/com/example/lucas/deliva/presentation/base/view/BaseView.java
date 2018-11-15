package com.example.lucas.deliva.presentation.base.view;

import android.content.Context;
import android.support.annotation.NonNull;

public interface BaseView {

    Context getContext();

    void showGenericError();
    void showConnectionError();

    void showProgress();
    void hideProgress();

    void showProgressDialog(@NonNull final String message);
    void dismissProgressDialog();

    void changeProgressDialogMessage(@NonNull final String message);
}
