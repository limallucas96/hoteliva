package com.example.lucas.deliva.presentation.cart.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.Order;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.cart.dialog.CartDialog;
import com.example.lucas.deliva.presentation.cart.presenter.CartActivityPresenter;
import com.example.lucas.deliva.presentation.order.adapter.CartRecyleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.lucas.deliva.presentation.order.view.OrderMenuFragment.KEY_EXTRA_CART;

public class CartActivity extends BaseActivity<CartActivityPresenter> implements CartActivityView {

    @BindView(R.id.recycle_view)
    protected RecyclerView mRecycleView;

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.cart_label)
    protected TextView mCartLabel;
    @BindView(R.id.cart_value)
    protected TextView mCartValue;

    @BindView(R.id.service_label)
    protected TextView mServiceLabel;
    @BindView(R.id.service_value)
    protected TextView mServiceValue;

    @BindView(R.id.total_label)
    protected TextView mTotalLabel;
    @BindView(R.id.total_value)
    protected TextView mTotalValue;

    protected Button mCartButton;
    private Boolean mShowOptions = true;

    private Order mOrder;
    private Double mOrderCost = 0.0;
    private CartRecyleAdapter mCartAdapter;
    private CartDialog mCartDialog;


    @NonNull
    @Override
    protected CartActivityPresenter createPresenter(@NonNull Context context) {
        return new CartActivityPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cart;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
        if (getIntent().getSerializableExtra(KEY_EXTRA_CART) != null) {
            mOrder = (Order) getIntent().getSerializableExtra(KEY_EXTRA_CART);
            mOrderCost = mOrder.getOrderCost();
            setupRecycle();
            setupCartValues();
        }
        checkCartStatus();
    }

    private void setupToolbar() {
        mToolbar.setTitle(R.string.total_cart);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupRecycle() {
        mCartAdapter = new CartRecyleAdapter();

        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleView.setAdapter(mCartAdapter);
        if (mOrder != null) {
            if (mOrder.getMenuList() != null && !mOrder.getMenuList().isEmpty())
                mCartAdapter.setData(mOrder.getMenuList());
        }

        mCartAdapter.setOnItemClickListener(new CartRecyleAdapter.OnItemClickListener() {
            @Override
            public void onIncreaseClickListener(@NonNull Menu menuItem) {
                updateCartValue(mOrder.getMenuList(), menuItem, true);
            }

            @Override
            public void onDecreaseClickListener(@NonNull Menu menuItem) {
                updateCartValue(mOrder.getMenuList(), menuItem, false);
            }
        });
    }

    private void updateCartValue(List<Menu> menuList, Menu menu, boolean isInscrease) {
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu itemMenu : menuList) {
                if (menu.getId() != null && isInscrease) {
                    mOrderCost = menu.getValue() + mOrder.getOrderCost();
                } else {
                    mOrderCost = mOrder.getOrderCost() - menu.getValue();
                }
                break;
            }
        }
        if (mOrderCost < 0.1)
            mOrderCost = 0.0;
        mOrder.setOrderCost(mOrderCost);
        mCartValue.setText(Util.formatCurrency(mOrder.getOrderCost()));
    }

    private void setupCartValues() {
        if (mOrder.getOrderCost() != null && mOrder.getOrderCost() > 0) {
            mCartValue.setText(Util.formatCurrency(mOrder.getOrderCost()));
        } else {
            mTotalValue.setText(Util.formatCurrency(0.0));
            mCartValue.setText(Util.formatCurrency(0.0));
        }
        mServiceValue.setText("7%");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.saveOrder(mOrder);
    }

    @OnClick(R.id.cart)
    protected void checkout() {
        Integer userId = mPresenter.getUser().getUserId();
        Integer roomId = mPresenter.getUser().getRoomId();
        if (userId != null && roomId != null) {
            mOrder.setUserId(userId);
            mOrder.setRoomId(roomId);
            mPresenter.createOrder(mOrder);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return mShowOptions;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear_cart_menu:
                showCartDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void checkCartStatus() {
        if (mOrder == null || mOrder.getMenuList().isEmpty()) {
//            mCartButton.setEnabled(false);
            mShowOptions = false;
        }
    }

    private void clearCart() {
        mOrder = null;
        mCartAdapter.setData(new ArrayList<Menu>());
        mRecycleView.removeAllViewsInLayout();
        checkCartStatus();
    }

    @Override
    public void onSuccessCreateOrder() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onErrorCreateOrder() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    private void showCartDialog() {
        mCartDialog = new CartDialog(this, new CartDialog.DialogListener() {
            @Override
            public void onConfirmClickListener() {
                clearCart();
            }

            @Override
            public void onCancelClickListener() {
                mCartDialog.dismiss();
            }
        });
        mCartDialog.show();
    }
}
