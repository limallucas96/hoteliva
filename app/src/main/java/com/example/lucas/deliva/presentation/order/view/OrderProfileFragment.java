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

public class OrderProfileFragment extends BaseFragment<BasePresenter> implements AdapterAwareFragment<OrderActivity> {


    @BindView(R.id.tab_layout)
    protected TabLayout mTabLayout;

    @BindView(R.id.view_pager)
    protected ViewPager mViewPager;
    private OrderTabsViewPagerAdapter mViewPagerAdapter;
    private int mCurrentFragmentPosition;


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
        setupViewPager();
    }


    private void setupViewPager() {
        mCurrentFragmentPosition = OrderTabsViewPagerAdapter.FragmentType.PROFILE_FRAGMENT.getValue();
        mViewPagerAdapter = new OrderTabsViewPagerAdapter(getChildFragmentManager(), getActivity()) {

            @Override
            protected void onFragmentsCreated() {
                sendAdapterAwareFragmentsCallbacks(0);
            }
        };

        mViewPager.setOffscreenPageLimit(mViewPagerAdapter.getCount());
        mViewPager.setAdapter(mViewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(final int position) {
                mCurrentFragmentPosition = position;
                sendAdapterAwareFragmentsCallbacks(position);
            }

            @Override
            public void onPageScrollStateChanged(final int state) {
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void sendAdapterAwareFragmentsCallbacks(final int position) {
        int totalPages = mViewPagerAdapter.getCount();
        for (int i = 0; i < totalPages; i++) {
            final Fragment fragment = mViewPagerAdapter.getFragment(i);
            if (fragment instanceof AdapterAwareFragment) {
                AdapterAwareFragment adapterAwareFragment = (AdapterAwareFragment) fragment;
                if (i == position) {
                    adapterAwareFragment.onAdapterChangedToThisFragment(getActivity());
                }
            }
        }
    }

    @Override
    public void onAdapterChangedToThisFragment(@NonNull OrderActivity activity) {

    }
}
