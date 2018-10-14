package com.example.lucas.deliva.presentation.order.adapter;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.OrderStatus;
import com.example.lucas.deliva.mechanism.connection.view.StepIndicator;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class OrderStatusRecycleAdapter extends BaseRecyclerAdapter<OrderStatus, OrderStatusRecycleAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new OrderStatusRecycleAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_order_status, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(mData.get(position), position);
    }

    @Override
    public boolean validateDate() {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mOrdered;
        private TextView mOnGoing;
        private TextView mDone;
        private TextView mStatus;
        private StepIndicator mStepIndicator;

        public ViewHolder(View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image);
            mOrdered = itemView.findViewById(R.id.ordered);
            mOnGoing = itemView.findViewById(R.id.on_going);
            mDone = itemView.findViewById(R.id.done);
            mStatus = itemView.findViewById(R.id.status);
            mStepIndicator = itemView.findViewById(R.id.step_indicator);

        }

        public void bind(@NonNull final OrderStatus status, final int position) {

            if (status.getImage() != null && !status.getImage().isEmpty()) {
                Picasso.with(itemView.getContext()).load(status.getImage()).into(mImage);
            }

            if (status.getCurrentStatus() != null && status.getCurrentLabelStatus() != null) {
                switch (status.getCurrentStatus()) {
                    case 0:
                        mOrdered.setTypeface(null, Typeface.BOLD);
                        mStatus.setText(R.string.order_status_id_1);
                        mStepIndicator.setCurrentStepPosition(0);
                        break;
                    case 1:
                        mOrdered.setTypeface(null, Typeface.NORMAL);
                        mOnGoing.setTypeface(null, Typeface.BOLD);
                        mStatus.setText(R.string.order_status_id_2);
                        mStepIndicator.setCurrentStepPosition(1);
                        break;
                    case 2:
                        mOrdered.setTypeface(null, Typeface.NORMAL);
                        mOnGoing.setTypeface(null, Typeface.NORMAL);
                        mDone.setTypeface(null, Typeface.BOLD);
                        mStatus.setText(R.string.order_status_id_3);
                        mStepIndicator.setCurrentStepPosition(2);
                        break;
                    default:
                        mOrdered.setTypeface(null, Typeface.BOLD);
                        mStepIndicator.setCurrentStepPosition(1);
                        break;
                }
            }

        }
    }
}
