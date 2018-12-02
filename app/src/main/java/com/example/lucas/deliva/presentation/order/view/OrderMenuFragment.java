package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.content.Intent;
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
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.Order;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.cart.view.CartActivity;
import com.example.lucas.deliva.presentation.order.adapter.OrderMenuRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderMenuFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class OrderMenuFragment extends BaseFragment<OrderMenuFragmentPresenter> implements OrderMenuFragmentView, SwipeRefreshLayout.OnRefreshListener {

    private static final int REQUEST_CODE_CONCLUDED = 1000;
    public static final String KEY_EXTRA_MENU = "KEY_EXTRA_MENU";
    public static final String KEY_EXTRA_CART = "KEY_EXTRA_CART";

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecycleView;
    @BindView(R.id.fab_new_evaluation)
    protected ImageView mOpenCart;

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

    private OrderMenuRecycleAdapter mMenuAdapter;

    private Order mOrder;
    private List<Menu> mMenuList;
    private Menu mMenu;

    @NonNull
    @Override
    protected OrderMenuFragmentPresenter createPresenter(@NonNull Context context) {
        return new OrderMenuFragmentPresenter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setupRecycle();
        showEmptyState();
        mPresenter.getMenuList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_menu;
    }

    private void setupRecycle() {
        mMenuAdapter = new OrderMenuRecycleAdapter();

        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleView.setAdapter(mMenuAdapter);


        mMenuAdapter.setOnItemClickListener(new OrderMenuRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemCLlickListener(@NonNull Menu menu, @NonNull int position) {
                Intent intent = new Intent(getContext(), OrderDetailsActivity.class);
                intent.putExtra(KEY_EXTRA_MENU, menu);
                startActivityForResult(intent, REQUEST_CODE_CONCLUDED);
            }
        });
    }

    private void showEmptyState() {
        mEmptyStateTitle.setText(getString(R.string.empty_state_no_menu_itens));
        mEmptySubTitle.setText(getString(R.string.empty_state_sorry));
        mTryAgain.setVisibility(View.GONE);
        mEmptyStateView.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        mOpenCart.setVisibility(View.GONE);
    }

    private void showLoading() {
        hideContainers();
        mLoadingView.setVisibility(View.VISIBLE);
    }

    private void hideContainers() {
        mLoadingView.setVisibility(View.GONE);
        mRecycleView.setVisibility(View.GONE);
        mEmptyStateView.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @OnClick(R.id.fab_new_evaluation)
    protected void openCart() {
        Intent intent = new Intent(getContext(), CartActivity.class);
        intent.putExtra(KEY_EXTRA_CART, mPresenter.getOrder());
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CONCLUDED) {
            if (resultCode == RESULT_OK) {
                mMenu = (Menu) data.getSerializableExtra(OrderDetailsActivity.MENU);
                mOrder = mPresenter.getOrder();
                if (mOrder == null) {
                    mOrder = new Order();
                }
                if (mOrder.getMenuList() == null) {
                    mOrder.setMenuList(new ArrayList<Menu>());
                }
                if (mMenu != null) {
                    if (mOrder.getMenuList().isEmpty())
                        mOrder.getMenuList().add(mMenu);
                    else
                        mOrder.getMenuList().add(0, mMenu);
                }
            mPresenter.saveOrder(mOrder);
        }
    }

}

    @Override
    public void onRefresh() {
        mMenuList = null;
        showLoading();
        mPresenter.getMenuList();
    }

    @Override
    public void onSuccessGetMenuList(List<Menu> result) {
        mMenuList = result;
        hideContainers();
        mMenuList = result;
        mMenuAdapter.setData(mMenuList);
        mRecycleView.setVisibility(View.VISIBLE);
        mOpenCart.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorGetMenuList() {
        hideContainers();
        showEmptyState();
    }
}

