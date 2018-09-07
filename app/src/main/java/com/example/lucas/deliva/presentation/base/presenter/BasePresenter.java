package com.example.lucas.deliva.presentation.base.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class BasePresenter {

    public BasePresenter() {
    }

    @NonNull
    public static BasePresenter nullPresenter (@NonNull final Context context){
        return new BasePresenter() {
        };
    }

    @CallSuper
    public void onCreate(@Nullable final Bundle savedInstanceState) {
    }

    @CallSuper
    public void onStart() {
    }

    @CallSuper
    public void onResume() {
    }

    @CallSuper
    public void onPause() {
    }

    @CallSuper
    public void onStop() {
    }

    @CallSuper
    public void onSaveInstanceState(@NonNull final Bundle outState) {
    }

    @CallSuper
    public void onDestroy() {
    }

    @CallSuper
    public void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data) {
    }

}
