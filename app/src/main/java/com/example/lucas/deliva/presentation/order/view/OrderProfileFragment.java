package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Purchase;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.base.view.adapter.OrderTabsViewPagerAdapter;
import com.example.lucas.deliva.presentation.base.view.AdapterAwareFragment;
import com.example.lucas.deliva.presentation.order.adapter.OrderStatusRecycleAdapter;
import com.example.lucas.deliva.presentation.order.adapter.ProfilePurchaseRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderProfileFragmentPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class OrderProfileFragment extends BaseFragment<OrderProfileFragmentPresenter> implements OrderProfileFragmentView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.total)
    protected TextView mTotal;
    @BindView(R.id.accommodation)
    protected TextView mAccomodation;
    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;
    @BindView(R.id.container)
    protected View mContainer;

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
    @BindView(R.id.swipe_right)
    protected ImageView mSwipeRight;

    private ProfilePurchaseRecycleAdapter mAdapter;
    private List<Purchase> mPurchaseList;


    @NonNull
    @Override
    protected OrderProfileFragmentPresenter createPresenter(@NonNull Context context) {
        return new OrderProfileFragmentPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_profile;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecycle();
        setMockProfileValues();
        showEmptyState();
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void setupRecycle() {
        mAdapter = new ProfilePurchaseRecycleAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
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
        mContainer.setVisibility(View.GONE);
        mEmptyStateTitle.setText(getString(R.string.empty_state_no_purchase));
        mEmptySubTitle.setText(getString(R.string.empty_state_swipe_right_to_shop));
        mTryAgain.setVisibility(View.GONE);
        mEmptyStateView.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        mSwipeRight.setVisibility(View.VISIBLE);
    }


    @Override
    public void onRefresh() {
        mPurchaseList = null;
        showLoading();
        mPresenter.getUserWallet();
    }

    @Override
    public void onSuccessGetUserWallet(@NonNull List<Purchase> purchaseList) {
        hideContainers();
        mPurchaseList = purchaseList;
        mAdapter.setData(mPurchaseList);
        mContainer.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorGetUserWallet() {
        hideContainers();
        showEmptyState();
    }

    private void setMockProfileValues() {
        mAccomodation.setText("15/10/2018 - 20/10/2018");
        mTotal.setText(Util.formatCurrency(180.00));

    }
}
