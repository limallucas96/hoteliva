package com.example.lucas.deliva.presentation.order.adapter;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.mock.OrderStatus;
import com.example.lucas.deliva.data.model.type.OrderStatusType;
import com.example.lucas.deliva.mechanism.connection.view.StepIndicator;
import com.example.lucas.deliva.presentation.base.view.adapter.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import static android.provider.Settings.System.getString;
import static com.example.lucas.deliva.data.model.type.OrderStatusType.REQUESTED;

public class OrderStatusRecycleAdapter extends BaseRecyclerAdapter<OrderStatus, OrderStatusRecycleAdapter.ViewHolder> {

    private OnItemClickListener mListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new OrderStatusRecycleAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_order_status, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(mData.get(position), position);
    }

    public void onItemClickListener(OnItemClickListener lister) {
        this.mListener = lister;
    }

    @Override
    public boolean validateDate() {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mOrdered;
        private TextView mId;
        private TextView mOnGoing;
        private TextView mDone;
        private TextView mStatus;
        private StepIndicator mStepIndicator;
        private Button mConfirm;

        private void setButtonListener(@NonNull final OrderStatus status) {
            mConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onConfirmButtonClickLister(status);
                    }
                }
            });
        }

        public ViewHolder(View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.order_id);
            mOrdered = itemView.findViewById(R.id.ordered);
            mOnGoing = itemView.findViewById(R.id.on_going);
            mDone = itemView.findViewById(R.id.done);
            mStatus = itemView.findViewById(R.id.status);
            mStepIndicator = itemView.findViewById(R.id.step_indicator);
            mConfirm = itemView.findViewById(R.id.confirm);

        }

        public void bind(@NonNull final OrderStatus status, final int position) {

            if (status.getOrderId() != null) {
                mId.setText(AppApplication.getAppContext().getString(R.string.order_status_title));
            }


            if (status.getCurrentStatus() != null && status.getRoomNumber() != null) {

                OrderStatusType orderStatusType = OrderStatusType.fromInt(status.getCurrentStatus());

                switch (orderStatusType) {
                    case REQUESTED:
                        mOrdered.setTypeface(null, Typeface.BOLD);
                        mStatus.setText(R.string.order_status_id_1);
                        mStepIndicator.setCurrentStepPosition(0);
                        break;

                    case APPROVED:
                        mOrdered.setTypeface(null, Typeface.NORMAL);
                        mOnGoing.setTypeface(null, Typeface.BOLD);
                        mStatus.setText(R.string.order_status_id_2);
                        mStepIndicator.setCurrentStepPosition(1);
                        break;

                    case DONE:
                        mOrdered.setTypeface(null, Typeface.NORMAL);
                        mOnGoing.setTypeface(null, Typeface.NORMAL);
                        mDone.setTypeface(null, Typeface.BOLD);
                        mConfirm.setVisibility(View.VISIBLE);
                        setButtonListener(status);
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

    public interface OnItemClickListener {
        void onConfirmButtonClickLister(@NonNull OrderStatus status);
    }
}
