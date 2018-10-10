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
import android.widget.Toast;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.example.lucas.deliva.presentation.cart.view.CartActivity;
import com.example.lucas.deliva.presentation.order.adapter.OrderMenuRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderMenuFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class OrderMenuFragment extends BaseFragment<OrderMenuFragmentPresenter> {

    private static final int REQUEST_CODE_CONCLUDED = 1000;
    public static final String KEY_EXTRA_MENU = "KEY_EXTRA_MENU";

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecycleView;

    @BindView(R.id.swipe_refresh_layout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    private OrderMenuRecycleAdapter mMenuAdapter;

    //TODO - Mock. Remove later
    private List<Menu> mMenuList = new ArrayList<>();
    private Menu mMenu;
    private Order mOrder;

    @NonNull
    @Override
    protected OrderMenuFragmentPresenter createPresenter(@NonNull Context context) {
        return new OrderMenuFragmentPresenter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRecycleMockData();
        setupRecycle();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_menu;
    }

    private void setupRecycle() {
        mMenuAdapter = new OrderMenuRecycleAdapter();

        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleView.setAdapter(mMenuAdapter);
        mMenuAdapter.setData(mMenuList);

        mMenuAdapter.setOnItemClickListener(new OrderMenuRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemCLlickListener(@NonNull Menu menu, @NonNull int position) {
                Intent intent = new Intent(getContext(), OrderDetailsActivity.class);
                intent.putExtra(KEY_EXTRA_MENU, menu);
                startActivityForResult(intent, REQUEST_CODE_CONCLUDED);
            }
        });
    }

    private void setRecycleMockData() {
        mMenuList.add(new Menu(1, "Korean", "Barbecue", 19.90, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(2, "Lucas", "Lima", 19.99, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(3, "Bruno", "Silva", 9.99, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(4, "Sergio", "Furgeri", 10.00, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(5, "ADS", "6 Semestre", 6.66, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
    }

    @OnClick(R.id.cart)
    protected void openCart() {
        Intent intent = new Intent(getContext(), CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CONCLUDED) {
            if (resultCode == RESULT_OK) {
                mMenu = (Menu) data.getSerializableExtra(OrderDetailsActivity.MENU);
                if (mOrder == null) {
                    mOrder = new Order();
                }
                if (mOrder.getMenuList() == null) {
                    mOrder.setMenuList(new ArrayList<Menu>());
                }
                if (mMenu != null) {
                    mOrder.getMenuList().add(mMenu);
                }
            }
        }
    }
}

