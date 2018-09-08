package com.example.lucas.deliva.presentation.base.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.AppApplication;

public abstract class OrderTabsViewPagerAdapter extends FragmentPagerAdapter {

    private static final int NUMBER_OF_PAGES = 3;

    private final SparseArray<Fragment> mRegisteredFragments = new SparseArray<>();
    private Context mContext;

    public OrderTabsViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mRegisteredFragments.put(position, fragment);
        if (position == getCount() - 1) {
            onFragmentsCreated();
        }
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mRegisteredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @NonNull
    public Fragment getFragment(final int position) {
        if (position >= 0 && position < mRegisteredFragments.size()) {
            return mRegisteredFragments.get(position);
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mContext != null) {
            FragmentType fragmentType = FragmentType.fromInt(position);
            switch (fragmentType) {
                case PROFILE_FRAGMENT:
                    return mContext.getString(R.string.profile_fragment_title);
                case ORDERS_FRAGMENT:
                    return mContext.getString(R.string.orders_fragment_title);
                case STATUS_FRAGMENT:
                    return mContext.getString(R.string.status_fragment_title);
                default:
                    return FragmentType.fromInt(position).getName();
            }
        } else {
            return FragmentType.fromInt(position).getName();
        }
    }

    @Override
    public Fragment getItem(int position) {
        FragmentType fragmentType = FragmentType.fromInt(position);
        switch (fragmentType) {
            case PROFILE_FRAGMENT:
                return null;
            case ORDERS_FRAGMENT:
                return null;
            case STATUS_FRAGMENT:
                return null;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    protected abstract void onFragmentsCreated();

    public enum FragmentType {

        INVALID(-1, "INVALID"),

        PROFILE_FRAGMENT(0, AppApplication.getContext().getString(R.string.profile_fragment_title)),

        ORDERS_FRAGMENT(1, AppApplication.getContext().getString(R.string.orders_fragment_title)),

        STATUS_FRAGMENT(2, AppApplication.getContext().getString(R.string.status_fragment_title));

        private final int value;
        private final String name;

        FragmentType(final int value, final String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static FragmentType fromInt(final int intValue) {
            for (final FragmentType type : FragmentType.values()) {
                if (intValue == type.getValue()) {
                    return type;
                }
            }
            return INVALID;
        }


    }
}
