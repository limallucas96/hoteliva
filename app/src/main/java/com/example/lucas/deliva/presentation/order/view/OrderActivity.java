package com.example.lucas.deliva.presentation.order.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.order.presenter.OrderActivityPresenter;

import butterknife.BindView;

public class OrderActivity extends BaseActivity<OrderActivityPresenter> implements OrderView {

    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation)
    protected NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.title)
    protected TextView mTextView;


    @NonNull
    @Override
    protected OrderActivityPresenter createPresenter(@NonNull Context context) {
        return new OrderActivityPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar();
    }

    private void setToolbar(){
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            mTextView.setText("home");
        }
    }
}
