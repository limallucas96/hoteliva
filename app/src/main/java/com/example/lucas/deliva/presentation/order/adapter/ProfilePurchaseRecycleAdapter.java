package com.example.lucas.deliva.presentation.order.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.Purchase;
import com.example.lucas.deliva.data.model.type.PaymentStatusType;
import com.example.lucas.deliva.mechanism.connection.view.Util;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;

public class ProfilePurchaseRecycleAdapter extends BaseRecyclerAdapter<Purchase, ProfilePurchaseRecycleAdapter.ViewHolder> {
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

        public void bind(@NonNull final Purchase purchase, final int position) {

            if (purchase.getPurchaseId() != null) {
                mOrderId.setText(
                        AppApplication.getAppContext().getString(
                                R.string.purchase_id, purchase.getPurchaseId()));
            }

            if (purchase.getDate() != null) {
                mDate.setText(purchase.getDate().toString());
            }

            if (purchase.getCost() != null) {
                mPrice.setText(Util.formatCurrency(purchase.getCost()));
            }

            if (purchase.getStatus() != null) {
                mStatus.setText("" + purchase.getStatus());
                PaymentStatusType paymentStatusType = PaymentStatusType.fromInt(purchase.getStatus());

                switch (paymentStatusType) {
                    case PAID:
                        break;
                    case PENDENT:
                        break;
                    case INVALID:
                        break;
                }
            }

        }
    }

}


