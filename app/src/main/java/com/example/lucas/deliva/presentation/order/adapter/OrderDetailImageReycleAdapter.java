package com.example.lucas.deliva.presentation.order.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.OrderDetailImage;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class OrderDetailImageReycleAdapter extends BaseRecyclerAdapter<OrderDetailImage, OrderDetailImageReycleAdapter.ViewHolder> {
    @Override
    public OrderDetailImageReycleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new OrderDetailImageReycleAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_order_detail_pictures, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(OrderDetailImageReycleAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(mData.get(position), position);
    }

    @Override
    public boolean validateDate() {
        return false;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mPictureIndicator;

        ViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mPictureIndicator = itemView.findViewById(R.id.pictures_indicator);

        }

        public void bind(@NonNull final OrderDetailImage menu, final int posistion) {

            if (menu.getImage() != null && !menu.getImage().isEmpty()) {
                Picasso.with(itemView.getContext()).load(menu.getImage()).resize(600, 200).centerCrop().into(mImageView);
                mPictureIndicator.setText(posistion+1 + "/" + mData.size());
            }

        }

    }


}
