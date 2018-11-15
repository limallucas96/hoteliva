package com.example.lucas.deliva.presentation.order.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class OrderMenuRecycleAdapter extends BaseRecyclerAdapter<Menu, OrderMenuRecycleAdapter.ViewHolder> {

    private OnItemClickListener mListener;

    @Override
    public OrderMenuRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new OrderMenuRecycleAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_order_menu, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(OrderMenuRecycleAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(mData.get(position), position);
    }

    @Override
    public boolean validateDate() {
        return false;
    }

    public void setOnItemClickListener(@NonNull final OnItemClickListener listener) {
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTitle;
        private TextView mDescription;
        private TextView mPrice;
        private LinearLayout mCardContainer;


        public ViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            mPrice = itemView.findViewById(R.id.price);
            mCardContainer = itemView.findViewById(R.id.card_container);
        }

        private void bind(@NonNull final Menu menu, final int posistion) {

            if (menu.getImg() != null && !menu.getName().isEmpty()) {
                Picasso.with(itemView.getContext()).load(menu.getImg()).resize(600, 200).centerCrop().into(mImageView);

            }

            if (menu.getName() != null && !menu.getName().isEmpty()) {
                mTitle.setText(menu.getName());
            }

            if (menu.getDescription() != null && !menu.getDescription().isEmpty()) {
                mDescription.setText(menu.getDescription());
            }

            if (menu.getValue() != null) {
                mPrice.setText(Util.formatCurrency(menu.getValue()));
            }

            mCardContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        mListener.onItemCLlickListener(menu, posistion);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemCLlickListener(@NonNull Menu menu, @NonNull final int position);
    }

}
