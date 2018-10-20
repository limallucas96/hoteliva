package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.base.view.adapter.OrderTabsViewPagerAdapter;
import com.example.lucas.deliva.presentation.base.view.AdapterAwareFragment;
import com.example.lucas.deliva.presentation.order.presenter.OrderProfileFragmentPresenter;

import butterknife.BindView;

public class OrderProfileFragment extends BaseFragment<OrderProfileFragmentPresenter> implements OrderProfileFragmentView {

    @BindView(R.id.total)
    protected TextView mTotal;

    @BindView(R.id.accommodation)
    protected TextView mAccomodation;

    @BindView(R.id.recycle_view)
    protected RecyclerView mRecyclerView;


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

    }





}
