package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.base.view.adapter.OrderTabsViewPagerAdapter;
import com.example.lucas.deliva.presentation.base.view.AdapterAwareFragment;

import butterknife.BindView;

public class OrderProfileFragment extends BaseFragment<BasePresenter> {

    @NonNull
    @Override
    protected BasePresenter createPresenter(@NonNull Context context) {
        return BasePresenter.nullPresenter(context);
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
