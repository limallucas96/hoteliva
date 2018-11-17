package com.example.lucas.deliva.presentation.order.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.type.OrderStatusType;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ProfilePurchaseRecycleAdapter extends BaseRecyclerAdapter<Balance, ProfilePurchaseRecycleAdapter.ViewHolder> {
    @Override
    public ProfilePurchaseRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ProfilePurchaseRecycleAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_profile_cart, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ProfilePurchaseRecycleAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(mData.get(position), position);
    }

    @Override
    public boolean validateDate() {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mOrderId;
        private TextView mDate;
        private TextView mPrice;
        private TextView mStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            mOrderId = itemView.findViewById(R.id.order_id);
            mDate = itemView.findViewById(R.id.date);
            mPrice = itemView.findViewById(R.id.price);
            mStatus = itemView.findViewById(R.id.status);
        }

        public void bind(@NonNull final Balance balance, final int position) {

            if (balance.getIdService() != null) {
                mOrderId.setText(
                        AppApplication.getAppContext().getString(
                                R.string.purchase_id, balance.getIdService()));
            }

            if (balance.getDate() != null) {
                mDate.setText(balance.getDate().substring(5, 16));
            }

            if (balance.getTotalValue() != null) {
                mPrice.setText(Util.formatCurrency(balance.getTotalValue()));
            }

            if (balance.getStatus() != null && !balance.getStatus().isEmpty()) {
                OrderStatusType orderStatusType = OrderStatusType.fromInt(Integer.valueOf(balance.getStatus()));

                switch (orderStatusType) {
                    case PENDENT:
                        mStatus.setText(R.string.purchase_status_pending);
                        break;
                }
            }
        }
    }

}


