package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
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

    @BindView(R.id.fragments)
    protected FrameLayout mFrameFragment;

    private OrdersFragment mOrdersFragment;
    private OrderProfileFragment mOrderProfileFragment;



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
        setupFirstFragment();
    }

    private void setToolbar(){
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            mTextView.setText("QUARTO 7");
        }
    }

    private void setupFirstFragment(){
        clearFragmentBackStack();
        changeFragmentAddToStack("QUARTO 7", mOrdersFragment == null ?
                mOrdersFragment = new OrdersFragment() : mOrdersFragment);
    }


    private void clearFragmentBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public void changeFragmentAddToStack(@NonNull final String title, @NonNull final Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragments, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
        mTextView.setText(title);
    }

}
