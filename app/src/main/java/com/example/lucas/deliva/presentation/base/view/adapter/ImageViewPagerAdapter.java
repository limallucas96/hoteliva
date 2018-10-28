package com.example.lucas.deliva.presentation.base.view.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lucas.deliva.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ImageViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mData;

    public ImageViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mData = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        String image = mData.get(position);
        return VehicleImageFragment.newInstance(image, position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public void setData(@NonNull final List<String> data) {
        mData.clear();
        if (!data.isEmpty()) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public static final class VehicleImageFragment extends Fragment {

        private static final String IMAGE = "IMAGE";
        private String image;

        public static VehicleImageFragment newInstance(String image, int position) {
            Bundle args = new Bundle();
            args.putSerializable(IMAGE, image);

            VehicleImageFragment fragment = new VehicleImageFragment();
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if ((savedInstanceState != null) && savedInstanceState.containsKey(IMAGE)) {
                image = savedInstanceState.getString(IMAGE);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            image = getArguments().getString(IMAGE);

            View rootView = inflater.inflate(R.layout.fragment_order_detail_image, container, false);
            ImageView view = rootView.findViewById(R.id.image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(getActivity(), PromotionActivity.class);
//                    intent.putExtra(PromotionActivity.SPECIAL, promotion);
//                    startActivity(intent);
                }
            });

            if (image != null && !image.isEmpty()) {
                Picasso.with(view.getContext())
                        .load(image)
                        .placeholder(R.drawable.app_icon)
                        .into(view);
            } else {
                view.setImageResource(R.drawable.app_icon);
            }

            return rootView;
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putSerializable(IMAGE, image);
        }
    }
}
