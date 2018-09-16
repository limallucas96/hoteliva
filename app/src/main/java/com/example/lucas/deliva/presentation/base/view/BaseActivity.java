package com.example.lucas.deliva.presentation.base.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;

import butterknife.ButterKnife;

public abstract class BaseActivity<Presenter extends BasePresenter> extends AppCompatActivity implements BaseView {

    private static final String TAG = BaseActivity.class.getSimpleName();

    protected Presenter mPresenter;

    private AlertDialog mProgressDialog;
    private AlertDialog mConnectionDialog;
    private boolean mIsVisible;

    @NonNull
    protected abstract Presenter createPresenter(@NonNull final Context context);


    @LayoutRes
    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = createPresenter(this);
    }

    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
        mIsVisible = true;
//        tagScreenForAnalytics();
//        checkUpdate();
    }

    @Override
    public void onPause() {
        mIsVisible = false;
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showGenericError() {

    }

    @Override
    public void showConnectionError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgressDialog(@NonNull String message) {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
