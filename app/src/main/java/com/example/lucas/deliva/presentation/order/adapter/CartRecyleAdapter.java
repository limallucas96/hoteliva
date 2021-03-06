package com.example.lucas.deliva.presentation.order.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartRecyleAdapter extends BaseRecyclerAdapter<Menu, CartRecyleAdapter.ViewHolder> {

    private OnItemClickListener mListener;

    @Override
    public CartRecyleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new CartRecyleAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_cart, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CartRecyleAdapter.ViewHolder viewHolder, int position) {
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

        private ImageView mImage;
        private TextView mTitle;
        private TextView mPrice;
        private Button mIncrease;
        private Button mDecrease;
        private Button mValue;
        private Integer amount = 1;
        private View mItemContainer;

        public ViewHolder(View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mPrice = itemView.findViewById(R.id.price);
            mIncrease = itemView.findViewById(R.id.increase);
            mDecrease = itemView.findViewById(R.id.decrease);
            mValue = itemView.findViewById(R.id.value);
            mItemContainer = itemView.findViewById(R.id.item_container);
        }

        public void bind(@NonNull final Menu menu, final int position) {

            if (menu != null) {
                if (menu.getName() != null && !menu.getName().isEmpty()) {
                    mTitle.setText(menu.getName());
                }

                if (menu.getValue() != null) {
                    mPrice.setText(Util.formatCurrency(menu.getValue()));
                }

                if (menu.getImg() != null && !menu.getImg().isEmpty()) {
                    Picasso.with(itemView.getContext()).
                            load(menu.getImg()).
                            resize(50, 50).centerCrop().into(mImage);
                }

                if (menu.getAmout() != null && menu.getAmout() >= 0) {
                    mValue.setText(String.valueOf(menu.getAmout()));
                }

                mIncrease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        amount = menu.getAmout() + 1;
                        menu.setAmout(amount);
                        mValue.setText(String.valueOf(menu.getAmout()));
                        if (mListener != null) {
                            mListener.onIncreaseClickListener(menu);
                        }
                    }
                });

                mDecrease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (menu.getAmout() > 0) {
                            amount = menu.getAmout() - 1;
                            menu.setAmout(amount);
                            mValue.setText(String.valueOf(menu.getAmout()));
                            if (mListener != null) {
                                mListener.onDecreaseClickListener(menu);
                            }
                        }
                    }
                });

                mItemContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mListener != null) {
                            mListener.onItemClickListener(menu);
                        }
                    }
                });
            }
        }
    }

    public interface OnItemClickListener {
        void onIncreaseClickListener(@NonNull final Menu menuItem);

        void onDecreaseClickListener(@NonNull final Menu menuItem);

        void onItemClickListener(@NonNull final Menu menuItem);
    }

}



