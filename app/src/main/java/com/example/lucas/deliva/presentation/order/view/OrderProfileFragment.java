package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Purchase;
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

public class OrderProfileFragment extends BaseFragment<OrderProfileFragmentPresenter> implements OrderProfileFragmentView {

    @BindView(R.id.total)
    protected TextView mTotal;

    @BindView(R.id.accommodation)
    protected TextView mAccomodation;

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

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
        setupMockDate();
        setupRecycle();

    }

    private void setupRecycle() {
        mAdapter = new ProfilePurchaseRecycleAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setData(mPurchaseList);

    }


    private void setupMockDate() {
        mPurchaseList = new ArrayList<>();
        mPurchaseList.add(new Purchase(123, "12/10/2018", 1, 120.00));
        mPurchaseList.add(new Purchase(454, "12/10/2018", 2, 80.00));
        mPurchaseList.add(new Purchase(543, "02/10/2018", 2, 90.00));
        mPurchaseList.add(new Purchase(454, "28/08/2018", 1, 113.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 1, 105.00));
    }


}
