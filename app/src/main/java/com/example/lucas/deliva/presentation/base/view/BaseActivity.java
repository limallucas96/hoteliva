package com.example.lucas.deliva.presentation.base.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;
import com.example.lucas.deliva.mechanism.connection.locale.LocaleManager;
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
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
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
        return this != null ? this : AppApplication.getAppContext();
    }

    @Override
    public void showGenericError() {

    }

    @Override
    public void showConnectionError() {

    }

    @Override
    public void hideProgress() {
        dismissProgressDialog();
    }

    @Override
    public void showProgress() {
        showProgressDialog(getString(R.string.alert_loading));
    }

    @Override
    public void showProgressDialog(@NonNull final String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_progress, null);
        TextView text = (TextView) view.findViewById(R.id.dialog_progress_text);
        text.setText(content);

        builder.setCancelable(false);
        builder.setView(view);
        mProgressDialog = builder.create();
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        try {
            if (mProgressDialog != null) {
                mProgressDialog.dismiss();
            }
        } catch (Exception ex) {
            Log.e(TAG, "Problem dismissing dialog");
        }
    }

    @Override
    public void changeProgressDialogMessage(@NonNull final String message) {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.setMessage(message);
            }
        } catch (Exception ex) {
            Log.e(TAG, "Problem dismissing dialog");
        }
    }

}
