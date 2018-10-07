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
import com.example.lucas.deliva.data.model.mock.OrderDetailImage;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.order.adapter.OrderDetailImageReycleAdapter;
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

    private OrderDetailImageReycleAdapter mImageAdapter;

    //TODO - Mock. Remove later
    private List<OrderDetailImage> mImageList = new ArrayList<>();

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
        mImageAdapter = new OrderDetailImageReycleAdapter();

        mRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        mRecycleView.setAdapter(mImageAdapter);
        mImageAdapter.setData(mImageList);
    }

    private void setRecycleMockData() {
        mImageList.add(new OrderDetailImage("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mImageList.add(new OrderDetailImage("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mImageList.add(new OrderDetailImage("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mImageList.add(new OrderDetailImage("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mImageList.add(new OrderDetailImage("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
    }
}
