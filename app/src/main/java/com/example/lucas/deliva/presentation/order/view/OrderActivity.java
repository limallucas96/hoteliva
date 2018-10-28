package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.UserReturn;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.login.view.LoginActivity;
import com.example.lucas.deliva.presentation.order.presenter.OrderActivityPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity<OrderActivityPresenter> implements OrderActivityView {

    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation)
    protected NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.title)
    protected TextView mTextView;

    @BindView(R.id.fragments)
    protected FrameLayout mFrameFragment;

    private OrdersFragment mOrdersFragment;

    // Navigation Menu Header
    protected TextView mMenuName;
    protected TextView mMenuCompany;

    private UserReturn mUser;

    @NonNull
    @Override
    protected OrderActivityPresenter createPresenter(@NonNull Context context) {
        return new OrderActivityPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter.getUser() != null) {
            mUser = mPresenter.getUser();
        }

        setToolbar();
        setupFirstFragment();
        setupHeaderDrawer();
        setupDrawer();
    }

    private void setToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            if (mUser.getRoom() != null) {
                mTextView.setText(mUser.getRoom());
            }
        }
    }

    private void setupFirstFragment() {
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

    @OnClick(R.id.drawer_footer)
    protected void onExitClick() {
        showLogoutDialog();
    }

    private void setupHeaderDrawer() {
        if (mNavigationView != null) {
            View header = mNavigationView.getHeaderView(0);
            mMenuName = header.findViewById(R.id.menu_profile_username);
            mMenuCompany = header.findViewById(R.id.menu_company);
            header.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            if (mUser.getName() != null) {
                mMenuName.setText(mUser.getName());
            }
            if (mUser.getRoom() != null) {
                mMenuCompany.setText(mUser.getRoom());
            }
        }
    }

    private void showLogoutDialog() {
        if (!isFinishing()) {
            new AlertDialog.Builder(OrderActivity.this)
                    .setCancelable(true)
                    .setTitle(R.string.exit_app_dialog_title)
                    .setMessage(R.string.exit_app_dialog_message)
                    .setPositiveButton(R.string.positive_option, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mPresenter.logoutUser();
                            Intent intent = new Intent(OrderActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.negative_option, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
        }
    }

    public void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.negative_option, R.string.positive_option);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupHeaderDrawer();
    }

}
