package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.order.presenter.OrderDetailsActivityPresenter;

import butterknife.BindView;

public class OrderDetailsActivity extends BaseActivity<OrderDetailsActivityPresenter> implements OrderDetailsView {

    static final String EXTRA_KEY_MENU = "EXTRA_KEY_MENU";

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @NonNull
    @Override
    protected OrderDetailsActivityPresenter createPresenter(@NonNull Context context) {
        return new OrderDetailsActivityPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar();
    }

    private void setToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//            mTextView.setText("QUARTO 7");
        }
    }
}
