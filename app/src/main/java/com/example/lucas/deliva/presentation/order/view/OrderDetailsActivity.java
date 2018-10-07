package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.order.adapter.OrderMenuRecycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderDetailsActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderDetailsActivity extends BaseActivity<OrderDetailsActivityPresenter> implements OrderDetailsView {

    static final String EXTRA_KEY_MENU = "EXTRA_KEY_MENU";

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecycleView;

    private OrderMenuRecycleAdapter mMenuAdapter;

    //TODO - Mock. Remove later
    private List<Menu> mMenuList = new ArrayList<>();

    @NonNull
    @Override
    protected OrderDetailsActivityPresenter createPresenter(@NonNull Context context) {
        return new OrderDetailsActivityPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRecycleMockData();
        setupRecycle();
        setToolbar();
    }

    private void setToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//            mTextView.setText("QUARTO 7");
        }
    }

    private void setupRecycle() {
        mMenuAdapter = new OrderMenuRecycleAdapter();

        mRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        mRecycleView.setAdapter(mMenuAdapter);
        mMenuAdapter.setData(mMenuList);
    }

    private void setRecycleMockData() {
        mMenuList.add(new Menu("Diogo", "Silva", 00.00, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("Lucas", "Lima", 19.99, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("Bruno", "Silva", 9.99, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("Sergio", "Furgeri", 10.00, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu("ADS", "6 Semestre", 6.66, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
    }
}
