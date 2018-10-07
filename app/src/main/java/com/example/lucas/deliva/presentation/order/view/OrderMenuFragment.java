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
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.example.lucas.deliva.presentation.order.adapter.OrderMenuRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderMenuFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.lucas.deliva.presentation.order.view.OrderDetailsActivity.EXTRA_KEY_MENU;

public class OrderMenuFragment extends BaseFragment<OrderMenuFragmentPresenter> {

    private static final int REQUEST_CODE_CONCLUDED = 1000;

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecycleView;

    @BindView(R.id.swipe_refresh_layout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    private OrderMenuRecycleAdapter mMenuAdapter;

    //TODO - Mock. Remove later
    private List<Menu> mMenuList = new ArrayList<>();

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
                intent.putExtra(EXTRA_KEY_MENU, menu);
                startActivityForResult(intent, REQUEST_CODE_CONCLUDED);
            }
        });
    }

    private void setRecycleMockData() {
        mMenuList.add(new Menu("Diogo", "Silva", 00.00, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("Lucas", "Lima", 19.99,"https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("Bruno", "Silva", 9.99,"https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("Sergio", "Furgeri", 10.00,"https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("ADS", "6 Semestre", 6.66, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
    }
}

