package com.example.lucas.deliva.presentation.cart.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.example.lucas.deliva.presentation.cart.presenter.CartActivityPresenter;
import com.example.lucas.deliva.presentation.order.adapter.CartRecyleAdapter;

import java.util.List;

import butterknife.BindView;

import static com.example.lucas.deliva.presentation.order.view.OrderMenuFragment.KEY_EXTRA_CART;

public class CartActivity extends BaseActivity<CartActivityPresenter> implements CartActivityView {

    @BindView(R.id.recycle_view)
    protected RecyclerView mRecycleView;

    @BindView(R.id.cart_label)
    TextView mCartLabel;
    @BindView(R.id.cart_value)
    TextView mCartValue;

    @BindView(R.id.service_label)
    TextView mServiceLabel;
    @BindView(R.id.service_value)
    TextView mServiceValue;

    @BindView(R.id.total_label)
    TextView mTotalLabel;
    @BindView(R.id.total_value)
    TextView mTotalValue;

    private Order mOrder;
    private Double mOrderCost = 0.0;
    private CartRecyleAdapter mCartAdapter;


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

        if (getIntent().getSerializableExtra(KEY_EXTRA_CART) != null) {
            mOrder = (Order) getIntent().getSerializableExtra(KEY_EXTRA_CART);
            setupRecycle();
            setupCartCard(mOrder.getMenuList());
        }
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
            public void onInscreaseClickListener(@NonNull Menu menuItem) {
                updateCartValue(mOrder.getMenuList(), menuItem, true);
            }

            @Override
            public void onDecreaseClickListener(@NonNull Menu menuItem) {
                updateCartValue(mOrder.getMenuList(), menuItem, false);
            }
        });
    }

    private void updateCartValue(List<Menu> menuList, Menu menu, boolean isInscrease) {
        mOrderCost = Double.valueOf(mTotalValue.getText().toString());
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu itemMenu : menuList) {
                if (menu.getMenuId() != null && isInscrease) {
                    mOrderCost += menu.getPrice();
                } else {
                    mOrderCost -= menu.getPrice();
                }
                break;
            }
        }
        if (mOrderCost < 0.1)
            mOrderCost = 0.0;
        mCartValue.setText(String.format(String.valueOf("%.2f"), mOrderCost));
    }

    private void setupCartCard(List<Menu> menu) {
        if (menu != null && !menu.isEmpty()) {
            for (Menu itemMenu : menu) {
                mOrderCost += itemMenu.getPrice();
            }
        }
        mCartValue.setText(String.format(String.valueOf("%.2f"), mOrderCost));
        mCartValue.setText(String.format(String.valueOf("%.2f"), mOrderCost));
    }
}
