package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class OrderStatusFragment extends BaseFragment<OrderStatusFragmentPresenter> {

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
        setupMockStatus();
        setupRecycle();
    }

    private void setupRecycle() {
        mAdapter = new OrderStatusRecycleAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setData(mOrderStatus);

    }

    private void setupMockStatus() {
        mOrderStatus = new ArrayList<>();

        mOrderStatus.add(new OrderStatus(1, null, "https://img00.deviantart.net/5c51/i/2015/225/3/e/naruto_uzumaki___minimalist_by_triasfak-d95i7r9.png", 0, "0"));
        mOrderStatus.add(new OrderStatus(2, null, "http://s3.envato.com/files/253203724/DSC_2352111.jpg", 1, "1"));


    }
}
