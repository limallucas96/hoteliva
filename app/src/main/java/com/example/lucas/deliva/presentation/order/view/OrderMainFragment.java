package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;

import butterknife.BindView;

public class OrderMainFragment extends BaseFragment<BasePresenter> {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.title)
    protected TextView mTitle;




    @NonNull
    @Override
    protected BasePresenter createPresenter(@NonNull Context context) {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_oder_main;
    }
}
