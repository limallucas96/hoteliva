package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.OrderStatus;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.order.adapter.OrderStatusRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderStatusFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderStatusFragment extends BaseFragment<OrderStatusFragmentPresenter> implements OrderStatusFragmentView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycle_view)
    protected RecyclerView mRecyclerView;

    private OrderStatusRecycleAdapter mAdapter;
    private List<OrderStatus> mOrderStatus;

    @NonNull
    @Override
    protected OrderStatusFragmentPresenter createPresenter(@NonNull Context context) {
        return new OrderStatusFragmentPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_oder_main;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecycle();
    }

    private void setupRecycle() {
        mAdapter = new OrderStatusRecycleAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onSuccessGetOrderStatusList(@NonNull List<OrderStatus> result) {
        mOrderStatus = result;
        mAdapter.setData(mOrderStatus);
    }

    @Override
    public void onErrorGetOrderStatusList() {

    }

    @Override
    public void onRefresh() {
        mOrderStatus = null;
        mPresenter.getOrderStatusList();
    }
}
