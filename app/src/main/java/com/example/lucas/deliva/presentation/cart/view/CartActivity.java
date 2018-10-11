package com.example.lucas.deliva.presentation.cart.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.example.lucas.deliva.presentation.cart.presenter.CartActivityPresenter;
import com.example.lucas.deliva.presentation.order.adapter.CartRecyleAdapter;

import butterknife.BindView;

import static com.example.lucas.deliva.presentation.order.view.OrderMenuFragment.KEY_EXTRA_CART;

public class CartActivity extends BaseActivity<CartActivityPresenter> implements CartActivityView {

    @BindView(R.id.recycle_view)
    protected RecyclerView mRecycleView;

    private Order mOrder;

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

        mCartAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<Menu>() {
            @Override
            public void onItemClickListener(@NonNull View view, @NonNull Menu item) {

            }
        });
    }
}
