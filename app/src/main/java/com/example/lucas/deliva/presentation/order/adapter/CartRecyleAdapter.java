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
import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class CartRecyleAdapter extends BaseRecyclerAdapter<Menu, CartRecyleAdapter.ViewHolder> {
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mTitle;
        private TextView mPrice;
        private Button mIncrease;
        private Button mDecrease;
        private Button mValue;

        public ViewHolder(View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mPrice = itemView.findViewById(R.id.price);
            mIncrease = itemView.findViewById(R.id.increase);
            mDecrease = itemView.findViewById(R.id.decrease);
            mValue = itemView.findViewById(R.id.value);
        }

        public void bind(@NonNull final Menu menu, final int position) {

            if (menu != null) {
                if (menu.getTitle() != null && !menu.getTitle().isEmpty()) {
                    mTitle.setText(menu.getTitle());
                }

                if (menu.getPrice() != null) {
                    mPrice.setText(menu.getPrice().toString());
                }

                if (menu.getImageUrl() != null && !menu.getImageUrl().isEmpty()) {
                    Picasso.with(itemView.getContext()).
                            load(menu.getImageUrl()).
                            resize(50, 50).centerCrop().into(mImage);
                }
            }

        }
    }
}
