package com.example.lucas.deliva.presentation.base.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;

import butterknife.ButterKnife;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements BaseView {

    protected Presenter mPresenter;

    @NonNull
    protected abstract Presenter createPresenter(@NonNull final Context context);

    public abstract int getLayoutId();

    @NonNull

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter(getActivity());
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showConnectionError() {
        ((BaseActivity) getActivity()).showConnectionError();
    }

    @Override
    public void showGenericError() {
        ((BaseActivity) getActivity()).showGenericError();
    }

    @Override
    public void hideProgress() {
        ((BaseActivity) getActivity()).hideProgress();
    }

    @Override
    public void showProgress() {
        ((BaseActivity) getActivity()).showProgress();
    }

    @Override
    public void showProgressDialog(@NonNull final String content) {
        ((BaseActivity) getActivity()).showProgressDialog(content);
    }

    @Override
    public void dismissProgressDialog() {
        ((BaseActivity) getActivity()).dismissProgressDialog();
    }


}