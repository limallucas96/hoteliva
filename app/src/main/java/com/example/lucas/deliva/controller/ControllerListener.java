package com.example.lucas.deliva.controller;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;

public interface ControllerListener<T> {

    void onSuccess(@NonNull final T result);

    void onError(@NonNull final BusinessException errorCode);

    interface Simple {

        void onSuccess();

        void onError();
    }
}
