package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.order.adapter.OrderStatusRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderStatusFragmentPresenter;

import java.util.List;

import butterknife.BindView;

public class OrderStatusFragment extends BaseFragment<OrderStatusFragmentPresenter> implements OrderStatusFragmentView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycle_view)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.loading_view)
    protected View mLoadingView;
    @BindView(R.id.loading_more)
    protected View mLoadingMore;
    @BindView(R.id.empty_state_view)
    protected View mEmptyStateView;
    @BindView(R.id.empty_state_title)
    protected TextView mEmptyStateTitle;
    @BindView(R.id.empty_state_sub_title)
    protected TextView mEmptySubTitle;
    @BindView(R.id.try_again)
    protected Button mTryAgain;
    @BindView(R.id.swipe_left)
    protected ImageView mSwipeLeft;

    private OrderStatusRecycleAdapter mAdapter;
    private List<Balance> mOrderStatus;
    private User mUser;

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
        mUser = mPresenter.getUser();
        if (mUser.getUserId() != null && mUser.getRoomId() != null) {
            mPresenter.getOrderStatus(String.valueOf(mUser.getUserId()),
                    String.valueOf(mUser.getRoomId()));
        }
        setupRecycle();
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void setupRecycle() {
        mAdapter = new OrderStatusRecycleAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.onItemClickListener(new OrderStatusRecycleAdapter.OnItemClickListener() {
            @Override
            public void onConfirmButtonClickLister(@NonNull Balance item) {
                for (Balance orderStatus : mOrderStatus) {
                    if (orderStatus.getIdService() == item.getIdService()) {
                        mOrderStatus.remove(item);
                        break;
                    }
                }
                mAdapter.getData().clear();
                mAdapter.setData(mOrderStatus);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void showLoading() {
        hideContainers();
        mLoadingView.setVisibility(View.VISIBLE);
    }

    private void hideContainers() {
        mLoadingView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.GONE);
        mEmptyStateView.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void showEmptyState() {
//        mContainer.setVisibility(View.GONE);
        mEmptyStateTitle.setText(getString(R.string.empty_state_no_status));
        mEmptySubTitle.setText(getString(R.string.empty_state_swipe_left_to_shop));
        mTryAgain.setVisibility(View.GONE);
        mEmptyStateView.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        mSwipeLeft.setVisibility(View.VISIBLE);
    }


    @Override
    public void onSuccessGetOrderStatusList(@NonNull List<Balance> result) {
        hideContainers();
        mOrderStatus = result;
        mAdapter.setData(mOrderStatus);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorGetOrderStatusList() {
        hideContainers();
        showEmptyState();
    }

    @Override
    public void onRefresh() {
        mOrderStatus = null;
        showLoading();
        if (mUser.getUserId() != null && mUser.getRoomId() != null) {
            mPresenter.getOrderStatus(String.valueOf(mUser.getUserId()),
                    String.valueOf(mUser.getRoomId()));
        }
    }
}
