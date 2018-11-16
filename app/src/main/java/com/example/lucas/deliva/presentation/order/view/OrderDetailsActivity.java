package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.base.view.adapter.ImageViewPagerAdapter;
import com.example.lucas.deliva.presentation.order.adapter.OrderDetailImageReycleAdapter;
import com.example.lucas.deliva.presentation.order.presenter.OrderDetailsActivityPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.lucas.deliva.presentation.order.view.OrderMenuFragment.KEY_EXTRA_MENU;

public class OrderDetailsActivity extends BaseActivity<OrderDetailsActivityPresenter> implements OrderDetailsView {

    public final static String MENU = "MENU";

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;
    @BindView(R.id.title)
    protected TextView mTitle;

    @BindView(R.id.vehicle_pictures)
    protected ViewPager mPicturesViewPager;
    private ImageViewPagerAdapter mViewPagerAdapter;
    @BindView(R.id.pictures_indicator)
    protected TextView mPicturesIndicator;

    @BindView(R.id.name)
    protected TextView mName;
    @BindView(R.id.avarage_time)
    protected TextView mAvarageTime;
    @BindView(R.id.suits)
    protected TextView mSuits;
    @BindView(R.id.rating)
    protected RatingBar mRaiting;
    @BindView(R.id.description)
    protected TextView mDescription;
    @BindView(R.id.price)
    protected TextView mPrice;


    private OrderDetailImageReycleAdapter mImageAdapter;

    private Menu mMenu;
    private Order mOrder;

    //TODO - Mock. Remove later
    private List<String> mImageList = new ArrayList<>();

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

        if (getIntent().getSerializableExtra(KEY_EXTRA_MENU) != null) {
            mMenu = (Menu) getIntent().getSerializableExtra(KEY_EXTRA_MENU);
        }
        setRecycleMockData();
        setupViewPager();
        setToolbar();
        setupView();
    }

    private void setToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mTitle.setText(R.string.description);
        }
    }

    private void setRecycleMockData() {
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
        mImageList.add("https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg");
    }


    @OnClick(R.id.save)
    protected void save() {
        Intent intent = new Intent();
        intent.putExtra(MENU, mMenu);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void setupView() {
        if (mMenu != null) {
            if (mMenu.getName() != null) {
                mName.setText(mMenu.getName());
            }
            if (mMenu.getDescription() != null) {
                mDescription.setText(mMenu.getDescription());
            }
            if (mMenu.getValue() != null) {
                mPrice.setText(Util.formatCurrency(mMenu.getValue()));
            }
            mAvarageTime.setText("45 min");
            mSuits.setText("2 Pessoas");
            mRaiting.setNumStars(3);

        }
    }

    private void setupViewPager() {
        mViewPagerAdapter = new ImageViewPagerAdapter(getSupportFragmentManager());
        mPicturesViewPager.setAdapter(mViewPagerAdapter);
        mPicturesViewPager.setOffscreenPageLimit(mImageList.size());
        mPicturesViewPager.setAdapter(mViewPagerAdapter);
        mViewPagerAdapter.setData(mImageList);
        mPicturesIndicator.setText(String.format(Locale.getDefault(), "%d/%d", 1, mImageList.size()));
        mPicturesViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPicturesIndicator.setText(String.format(Locale.getDefault(), "%d/%d", position + 1, mImageList.size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
